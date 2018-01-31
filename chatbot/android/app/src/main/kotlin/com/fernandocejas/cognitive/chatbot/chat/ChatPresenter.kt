package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.R
import com.fernandocejas.cognitive.chatbot.chat.MessageViewModel.Type.RECEIVED
import javax.inject.Inject

class ChatPresenter
@Inject constructor(private val welcomeMessage: WelcomeMessage,
                    private val sendMessage: SendMessage) {

    internal lateinit var chatView: ChatView

    fun welcomeMessage() {
        val params = WelcomeMessage.Params(chatView.context().getString(R.string.welcome_message))
        val onSuccess = { message: Message -> chatView.renderMessage(MessageViewModel.from(message, RECEIVED)) }
        welcomeMessage.execute(onSuccess, params)
    }

    fun sendMessage(text: String) {
        val sentMessage = MessageViewModel(text, "10:30 PM", MessageViewModel.Type.SENT)
        chatView.renderMessage(sentMessage)
        val replyMessage = MessageViewModel("TODO: reply from API", "10:30 PM", MessageViewModel.Type.RECEIVED)
        chatView.renderMessage(replyMessage)
    }
}