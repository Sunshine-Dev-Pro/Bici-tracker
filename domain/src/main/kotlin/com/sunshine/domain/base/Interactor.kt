package com.sunshine.domain.base

import androidx.paging.PagedList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.sendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import java.util.concurrent.TimeUnit

abstract class Interactor<in P> {
    protected abstract val scope: CoroutineScope

    operator fun invoke(params: P, timeoutMs: Long = defaultTimeoutMs): Flow<InvokeStatus> {
        val channel = ConflatedBroadcastChannel<InvokeStatus>(InvokeIdle)
        scope.launch {
            try {
                withTimeout(timeoutMs) {
                    channel.send(InvokeStarted)
                    try {
                        doWork(params)
                        channel.send(InvokeSuccess)
                    } catch (t: Throwable) {
                        channel.send(InvokeError(t))
                    }
                }
            } catch (t: TimeoutCancellationException) {
                channel.send(InvokeTimeout)
            }
        }
        return channel.asFlow()
    }

    suspend fun executeSync(params: P) = withContext(scope.coroutineContext) { doWork(params) }

    protected abstract suspend fun doWork(params: P)

    companion object {
        private val defaultTimeoutMs = TimeUnit.MINUTES.toMillis(5)
    }
}

abstract class ResultInteractor<in P, R> {
    abstract val dispatcher: CoroutineDispatcher

    suspend operator fun invoke(params: P): R {
        return withContext(dispatcher) { doWork(params) }
    }

    protected abstract suspend fun doWork(params: P): R
}

interface ObservableInteractor<T> {
    val dispatcher: CoroutineDispatcher
    fun observe(): Flow<T>
}

abstract class PagingInteractor<P : PagingInteractor.Parameters<T>, T> : SubjectInteractor<P, PagedList<T>>() {
    interface Parameters<T> {
        val pagingConfig: PagedList.Config
        val boundaryCallback: PagedList.BoundaryCallback<T>?
    }
}

abstract class SuspendingWorkInteractor<P : Any, T : Any> :
    ObservableInteractor<T> {
    private val channel = ConflatedBroadcastChannel<T>()

    suspend operator fun invoke(params: P) = channel.send(doWork(params))

    abstract suspend fun doWork(params: P): T

    override fun observe(): Flow<T> = channel.asFlow()
}

abstract class SubjectInteractor<P : Any, T> :
    ObservableInteractor<T> {
    private val channel = ConflatedBroadcastChannel<P>()

    operator fun invoke(params: P) = channel.sendBlocking(params)

    abstract fun build(params: P): Flow<T>

    override fun observe(): Flow<T> = channel.asFlow()
        .distinctUntilChanged()
        .flatMapLatest { build(it) }
}

operator fun Interactor<Unit>.invoke() = invoke(Unit)
operator fun <T> SubjectInteractor<Unit, T>.invoke() = invoke(Unit)

fun <I : ObservableInteractor<T>, T> CoroutineScope.launchObserve(
    interactor: I,
    f: suspend (Flow<T>) -> Unit
) {
    launch(interactor.dispatcher) {
        f(interactor.observe())
    }
}
