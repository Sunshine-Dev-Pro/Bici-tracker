package com.sunshine.domain.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


class UiThread : AppCoroutineDispatcher {
    override val dispatcher: CoroutineDispatcher
        get() = Dispatchers.Main
}

class MainThread : AppCoroutineDispatcher {
    override val dispatcher: CoroutineDispatcher
        get() = Dispatchers.Main
}

class ComputationThread : AppCoroutineDispatcher {
    override val dispatcher: CoroutineDispatcher
        get() = Dispatchers.Default
}