package com.fernandocejas.cognitive.chatbot.chat

interface ChatView {
    fun renderMessage(message: MessageViewModel)
}