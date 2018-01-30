package com.fernandocejas.cognitive.chatbot.chat

import javax.inject.Inject

class ChatPresenter
@Inject constructor(private val welcomeMessage: WelcomeMessage,
                    private val sendMessage: SendMessage) {

    internal lateinit var chatView: ChatView

    fun welcomeMessage() {
        val textMessage = "Hi, my name is Watson... How can I help you?"
        val hiMessage = MessageViewModel(textMessage, "10:30 PM", MessageViewModel.Type.RECEIVED)
        chatView.renderMessage(hiMessage)
    }

    fun sendMessage(text: String) {
        val sentMessage = MessageViewModel(text, "10:30 PM", MessageViewModel.Type.SENT)
        chatView.renderMessage(sentMessage)
        val replyMessage = MessageViewModel("TODO: reply from API", "10:30 PM", MessageViewModel.Type.RECEIVED)
        chatView.renderMessage(replyMessage)
    }
}