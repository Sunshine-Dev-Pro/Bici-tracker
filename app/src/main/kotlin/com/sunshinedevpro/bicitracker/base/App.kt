package com.sunshinedevpro.bicitracker.base

import android.app.Application
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.sunshinedevpro.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        initTimber()

        if (BuildConfig.DEBUG) {
            //its only for debug
            retrieveFirebaseToken()
        }
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
        }
    }

    private fun retrieveFirebaseToken() {
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Timber.d("retrieveFirebaseToken failed: ${task.exception}")
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token = task.result?.token ?: ""

                Timber.d("Firebase token: $token")
            })
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
