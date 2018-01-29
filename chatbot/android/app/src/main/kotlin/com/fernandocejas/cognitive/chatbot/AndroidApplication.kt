package com.fernandocejas.cognitive.chatbot

import android.app.Application
import com.fernandocejas.cognitive.chatbot.di.ApplicationComponent
import com.fernandocejas.cognitive.chatbot.di.ApplicationModule
import com.fernandocejas.cognitive.chatbot.di.DaggerApplicationComponent
import com.squareup.leakcanary.LeakCanary

class AndroidApplication : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        injectMembers()
        initializeLeakDetection()
    }

    private fun injectMembers() = appComponent.inject(this)

    private fun initializeLeakDetection() {
        if (BuildConfig.DEBUG) LeakCanary.install(this)
    }
}