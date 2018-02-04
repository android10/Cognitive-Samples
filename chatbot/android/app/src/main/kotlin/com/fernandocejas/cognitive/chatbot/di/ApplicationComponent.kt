package com.fernandocejas.cognitive.chatbot.di

import com.fernandocejas.cognitive.chatbot.AndroidApplication
import com.fernandocejas.cognitive.chatbot.chat.ChatFragment
import com.fernandocejas.cognitive.chatbot.chat.ChatModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ChatModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
    fun inject(chatFragment: ChatFragment)
}