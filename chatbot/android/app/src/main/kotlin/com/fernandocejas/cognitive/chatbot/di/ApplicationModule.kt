package com.fernandocejas.cognitive.chatbot.di

import android.content.Context
import com.fernandocejas.cognitive.chatbot.AndroidApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: AndroidApplication) {
    @Provides @Singleton fun provideApplicationContext(): Context = application
}