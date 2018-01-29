package com.fernandocejas.cognitive.chatbot.chat

import javax.inject.Inject

class ChatPresenter
@Inject constructor() {

    internal lateinit var chatView: ChatView

    fun destroy() {
        chatView.dispose()
    }
}