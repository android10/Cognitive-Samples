package com.fernandocejas.cognitive.chatbot.chat

import com.ibm.watson.developer_cloud.conversation.v1.Conversation
import com.ibm.watson.developer_cloud.conversation.v1.model.Context
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatApi
@Inject constructor() {

    private val USER = "5bb88465-2121-4676-8122-2410505c1d87"
    private val PASS = "vRHx3f7Z8jac"

    private var conversationContext: Context? = null
    private val service: Conversation by lazy { Conversation(Conversation.VERSION_DATE_2017_05_26) }

    init {
        service.setUsernameAndPassword(USER, PASS)
    }

    fun startConversation(): MessageEntity {
        val input = InputData.Builder("Hi").build()
        val options = MessageOptions.Builder("cbdb4b9c-b231-40f8-ba56-78e48d66eaae").input(input).build()
        val response = service.message(options).execute()

        conversationContext = response.context

        return MessageEntity(response.input.text, response.output.text)
    }

    fun sendMessage(inputMessage: Message): MessageEntity {
        val newMessageOptions = MessageOptions.Builder()
                .workspaceId("cbdb4b9c-b231-40f8-ba56-78e48d66eaae")
                .input(InputData.Builder(inputMessage.text).build())
                .context(conversationContext)
                .build()

        val response = service.message(newMessageOptions).execute()

        return MessageEntity(response.input.text, response.output.text)
    }
}


