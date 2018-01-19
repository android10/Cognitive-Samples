package com.fernandocejas.cognitive.chatbot

import android.app.Application
import com.squareup.leakcanary.LeakCanary

class AndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeLeakDetection()
    }

    private fun initializeLeakDetection() {
        if (BuildConfig.DEBUG) LeakCanary.install(this)
    }
}