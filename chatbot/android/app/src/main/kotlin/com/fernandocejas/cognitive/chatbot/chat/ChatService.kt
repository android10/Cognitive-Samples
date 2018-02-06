package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.di.NetworkModule
import com.ibm.watson.developer_cloud.conversation.v1.Conversation
import com.ibm.watson.developer_cloud.conversation.v1.model.Context
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions
import dagger.Lazy
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatService
@Inject constructor(private val conversation: Lazy<Conversation>) {

    private var conversationContext: Context? = null

    fun startConversation(): MessageEntity {
        val input = InputData.Builder("Hi").build()
        val options = MessageOptions.Builder(NetworkModule.WORKSPACE).input(input).build()
        val response = conversation.get().message(options).execute()

        conversationContext = response.context

        return MessageEntity(response.input.text, response.output.text)
    }

    fun sendMessage(inputMessage: Message): MessageEntity {
        val newMessageOptions = MessageOptions.Builder()
                .workspaceId(NetworkModule.WORKSPACE)
                .input(InputData.Builder(inputMessage.text).build())
                .context(conversationContext)
                .build()

        val response = conversation.get().message(newMessageOptions).execute()

        return MessageEntity(response.input.text, response.output.text)
    }
}


