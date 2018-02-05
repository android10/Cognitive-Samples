package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.extension.space
import com.fernandocejas.cognitive.chatbot.util.DateTime
import javax.inject.Inject

class ChatDataSource
@Inject constructor(private val chatApi: ChatApi) {
    fun startConversation() = buildOutputMessage(chatApi.startConversation().output.text)
    fun sendMessage(inputMessage: Message) = buildOutputMessage(chatApi.sendMessage(inputMessage).output.text)

    private fun buildOutputMessage(strings: List<String>): Message {
        val outputMessage = StringBuilder()
        strings.forEach { outputMessage.append(it).append(String.space()) }

        return Message(outputMessage.toString().trim(), DateTime.now())
    }
}