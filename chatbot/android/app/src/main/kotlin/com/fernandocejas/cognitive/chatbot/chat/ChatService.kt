package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.extension.empty
import com.ibm.watson.developer_cloud.conversation.v1.Conversation
import com.ibm.watson.developer_cloud.conversation.v1.model.Context
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData.Builder
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

    fun startConversation() = WatsonMessage().send()
    fun sendMessage(inputMessage: Message) = WatsonMessage(inputMessage.text).send()

    inner class WatsonMessage(private val text: String = String.empty()) {

        fun send(): MessageEntity {
            val messageOptions = messageBuilder
                    .input(Builder(text).build())
                    .context(conversationContext)
                    .build()

            val messageResponse = conversation.get().message(messageOptions).execute()
            updateConversationContext(messageResponse)

            return MessageEntity(messageResponse.input.text, messageResponse.output.text)
        }

        private fun updateConversationContext(messageResponse: MessageResponse) {
            conversationContext = messageResponse.context
        }
    }
}


