package com.fernandocejas.cognitive.chatbot.chat

interface ChatApi {
    fun startConversation()
    fun sendMessage(message: Message): Message
}