package com.fernandocejas.cognitive.chatbot.chat

import android.content.Context

interface ChatView {
    fun renderMessage(message: MessageViewModel)
    fun context(): Context
}