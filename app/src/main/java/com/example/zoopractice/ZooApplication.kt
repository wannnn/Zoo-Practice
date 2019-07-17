package com.example.zoopractice

import android.app.Application
import android.content.Context
import timber.log.Timber

class ZooApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: ZooApplication? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}