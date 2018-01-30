package com.fernandocejas.cognitive.chatbot.chat

import javax.inject.Inject

class ChatPresenter
@Inject constructor() {

    internal lateinit var chatView: ChatView

    fun sayHi() {
        val hiMessage = MessageViewModel("Hi", "10:30 PM", MessageViewModel.Type.RECEIVED)
        chatView.renderMessage(hiMessage)
    }
}