package com.myfirstapp

import android.app.Application

// We use an Application to store something globally for our application
class AppApplication : Application() {
    companion object {
        lateinit var application: AppApplication
    }

    override fun onCreate() {
        super.onCreate()

        application = this
    }
}

// an Application is like the parent of all activities