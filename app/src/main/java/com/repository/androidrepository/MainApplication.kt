package com.repository.androidrepository

import android.app.Application
import android.os.StrictMode
import androidx.viewbinding.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            StrictMode.enableDefaults();
            Timber.plant(Timber.DebugTree())
        }
    }

}