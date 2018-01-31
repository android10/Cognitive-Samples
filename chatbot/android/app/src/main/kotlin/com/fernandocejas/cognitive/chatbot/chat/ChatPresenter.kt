package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.chat.MessageViewModel.Type.RECEIVED
import com.fernandocejas.cognitive.chatbot.chat.MessageViewModel.Type.SENT
import com.fernandocejas.cognitive.chatbot.util.DateTime
import javax.inject.Inject

class ChatPresenter
@Inject constructor(private val sendMessage: SendMessage) {

    internal lateinit var chatView: ChatView

    fun sendMessage(text: String) {
        val currentDateTime = DateTime.now()

        chatView.renderMessage(MessageViewModel.from(text, currentDateTime.time(), SENT))

        val params = SendMessage.Params(Message(text, currentDateTime))
        val onSuccess = { message: Message -> chatView.renderMessage(MessageViewModel.from(message, RECEIVED)) }
        sendMessage.execute(onSuccess, params)
    }
}