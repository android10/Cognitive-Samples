package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.chat.MessageViewModel.Type.RECEIVED
import javax.inject.Inject

class ChatPresenter
@Inject constructor(private val sendMessage: SendMessage) {

    internal lateinit var chatView: ChatView

    fun startConversation() {

    }

    fun sendMessage(message: MessageViewModel) {
        chatView.renderMessage(message)

        val params = SendMessage.Params(Message(message.message, message.createdAt))
        val onSuccess = { respondMsg: Message -> chatView.renderMessage(MessageViewModel.from(respondMsg, RECEIVED)) }
        sendMessage.execute(onSuccess, params)
    }
}