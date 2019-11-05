package com.rohit.kotlin.developerprofile

import android.app.Application

class ProfileApplication : Application() {
    init {
        instance = this
    }

    companion object {
        private var instance: ProfileApplication? = null

        fun getContext(): ProfileApplication {
            return instance as ProfileApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
    }
}