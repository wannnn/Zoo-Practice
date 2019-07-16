package com.example.zoopractice

import android.app.Application
import timber.log.Timber

class ZooApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}