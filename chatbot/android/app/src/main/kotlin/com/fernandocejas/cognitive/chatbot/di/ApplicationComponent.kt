package com.fernandocejas.cognitive.chatbot.di

import com.fernandocejas.cognitive.chatbot.AndroidApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
}