package com.fernandocejas.cognitive.chatbot.di

import com.fernandocejas.cognitive.chatbot.BuildConfig
import com.fernandocejas.cognitive.chatbot.chat.ChatApi
import com.fernandocejas.cognitive.chatbot.chat.ChatApi.Rest.*
import dagger.Module
import dagger.Provides
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides @Singleton fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(ChatApi.Rest.ENDPOINT_BASE)
                .client(createClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    private fun createClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(BasicAuthInterceptor(ChatApi.Rest.USER, ChatApi.Rest.PASS))
        okHttpClientBuilder.addInterceptor(ContentTypeInterceptor())

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }

        return okHttpClientBuilder.build()
    }

    class BasicAuthInterceptor(private val user: String, private val pass: String) : Interceptor {
        override fun intercept(chain: Chain): Response {
            val authenticatedRequest = chain.request().newBuilder()
                    .header("Authorization", Credentials.basic(user, pass)).build()
            return chain.proceed(authenticatedRequest)
        }
    }

    class ContentTypeInterceptor : Interceptor {
        override fun intercept(chain: Chain): Response {
            val requestBuilder = chain.request().newBuilder()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
            return chain.proceed(requestBuilder.build())
        }
    }
}