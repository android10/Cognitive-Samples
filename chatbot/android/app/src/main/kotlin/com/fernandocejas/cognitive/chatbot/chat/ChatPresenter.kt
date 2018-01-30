package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.chat.MessageViewModel.Type.RECEIVED
import javax.inject.Inject

class ChatPresenter
@Inject constructor(private val welcomeMessage: WelcomeMessage,
                    private val sendMessage: SendMessage) {

    internal lateinit var chatView: ChatView

    fun welcomeMessage() {
        welcomeMessage.execute { message -> chatView.renderMessage(MessageViewModel.from(message, RECEIVED)) }
    }

    fun sendMessage(text: String) {
        val sentMessage = MessageViewModel(text, "10:30 PM", MessageViewModel.Type.SENT)
        chatView.renderMessage(sentMessage)
        val replyMessage = MessageViewModel("TODO: reply from API", "10:30 PM", MessageViewModel.Type.RECEIVED)
        chatView.renderMessage(replyMessage)
    }
}