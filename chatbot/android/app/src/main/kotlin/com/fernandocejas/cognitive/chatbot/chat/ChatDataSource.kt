package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.extension.space
import com.fernandocejas.cognitive.chatbot.util.DateTime
import javax.inject.Inject

class ChatDataSource
@Inject constructor(private val chatService: ChatService) {

    fun startConversation() = messageFrom(chatService.startConversation().output)
    fun sendMessage(inputMessage: Message) = messageFrom(chatService.sendMessage(inputMessage).output)

    private fun messageFrom(strings: List<String>): Message {
        val outputMessage = StringBuilder()
        strings.forEach { outputMessage.append(it).append(String.space()) }

        return Message(outputMessage.toString().trim(), DateTime.now())
    }
}