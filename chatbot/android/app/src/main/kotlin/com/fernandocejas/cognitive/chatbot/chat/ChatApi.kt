package com.fernandocejas.cognitive.chatbot.chat

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.POST
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatApi
@Inject constructor(retrofit: Retrofit) {

    private val restApi by lazy { retrofit.create(Rest::class.java) }

    fun startConversation() = restApi.startConversation(Rest.VERSION).execute().body()!!
    fun sendMessage(inputMessage: Message) = restApi.sendMessage(Rest.VERSION).execute().body()!!

    interface Rest {
        companion object {
            const val USER = "5bb88465-2121-4676-8122-2410505c1d87"
            const val PASS = "vRHx3f7Z8jac"
            const val VERSION = "2017-05-26"
            //Api Urls
            const val ENDPOINT_BASE = "https://gateway.watsonplatform.net/conversation/api/v1/workspaces/cbdb4b9c-b231-40f8-ba56-78e48d66eaae/"
            const val ENDPOINT_MESSAGE = "message"
            //Header Params
            const val PARAM_CONVERSATION_ID = "conversation_id"
            //Query Params
            const val QUERY_PARAM_VERSION = "version"
        }

        @POST(ENDPOINT_MESSAGE) fun startConversation(@Query(QUERY_PARAM_VERSION) version: String):
                Call<MessageEntity>

        @POST(ENDPOINT_MESSAGE) fun sendMessage(@Query(QUERY_PARAM_VERSION) version: String):
                Call<MessageEntity>
    }

    class RequestBody()
}


