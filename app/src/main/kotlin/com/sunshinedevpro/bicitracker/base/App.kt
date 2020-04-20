package com.sunshinedevpro.bicitracker.base

import android.app.Application
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.sunshine.data.constant.LOG_TAG_DEBUG
import com.sunshinedevpro.BuildConfig
import com.sunshinedevpro.bicitracker.di.dataCacheModule
import com.sunshinedevpro.bicitracker.di.dataDeviceModule
import com.sunshinedevpro.bicitracker.di.dataModule
import com.sunshinedevpro.bicitracker.di.dataRemoteModule
import com.sunshinedevpro.bicitracker.di.domainModule
import com.sunshinedevpro.bicitracker.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()

        initTimber()

        retrieveFirebaseToken()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(getModules())
        }
    }

    private fun getModules() = listOf(
        uiModule,
        domainModule,
        dataModule,
        dataCacheModule,
        dataRemoteModule,
        dataDeviceModule
    )

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
//            Timber.plant(CrashlyticsTree())
        }
    }

    private fun retrieveFirebaseToken() {
        //its only for debug
        if (!BuildConfig.DEBUG) return

        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Timber.tag(LOG_TAG_DEBUG).d(task.exception, "retrieveFirebaseToken failed")
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token = task.result?.token

                Timber.tag(LOG_TAG_DEBUG).d("Firebase token: $token")
            })
    }

}