package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.util.DateTime
import javax.inject.Inject

class ChatDataSource
@Inject constructor(private val chatApi: ChatApi) {
    fun startConversation() = Message(chatApi.startConversation().output.text[0], DateTime.now())
    fun sendMessage(inputMessage: Message) =  Message(chatApi.sendMessage(inputMessage).output.text[0], DateTime.now())
}