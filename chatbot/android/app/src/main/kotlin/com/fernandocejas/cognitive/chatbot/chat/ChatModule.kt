package com.fernandocejas.cognitive.chatbot.chat

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ChatModule {
    companion object {
        const val API_CAR_TASKS = "ApiCarTasks"
        const val API_PIZZA_ORDER = "ApiPizzaOrder"
        const val API_FOOD_COACH = "ApiFoodCoach"
    }

    @Provides @Singleton @Named(API_CAR_TASKS) fun provideChatApiCarTasks(): ChatApi = ChatApiCarTasks()
    @Provides @Singleton @Named(API_PIZZA_ORDER) fun provideChatApiPizzaOrder(): ChatApi = ChatApiPizzaOrder()
    @Provides @Singleton @Named(API_FOOD_COACH) fun provideChatApiFoodCoach(): ChatApi = ChatApiFoodCoach()
}