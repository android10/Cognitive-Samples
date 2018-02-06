package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.di.NetworkModule
import com.fernandocejas.cognitive.chatbot.extension.empty
import com.ibm.watson.developer_cloud.conversation.v1.Conversation
import com.ibm.watson.developer_cloud.conversation.v1.model.Context
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse
import dagger.Lazy
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatService
@Inject constructor(private val conversation: Lazy<Conversation>,
        private val messageBuilder: MessageOptions.Builder) {

    private var conversationContext: Context = Context()

    fun startConversation(): MessageEntity {
        val watsonMessage = WatsonMessage()
        val messageResponse = watsonMessage.send()
        conversationContext = messageResponse.context
        return messageFromResponse(messageResponse)
    }

    fun sendMessage(inputMessage: Message): MessageEntity {
        val watsonMessage = WatsonMessage(inputMessage.text, conversationContext)
        val messageResponse = watsonMessage.send()
        conversationContext = messageResponse.context
        return messageFromResponse(messageResponse)
    }

    private fun messageFromResponse(response: MessageResponse) =
            MessageEntity(response.input.text, response.output.text)


    inner class WatsonMessage(private val text: String = String.empty(),
            private val context: Context = Context()) {

        fun send(): MessageResponse {
            val input = InputData.Builder(text).build()
            val options = messageBuilder.input(input).context(context).build()
            return conversation.get().message(options).execute()
        }
    }
}


