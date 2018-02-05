package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.chat.MessageViewModel.Type.RECEIVED
import com.fernandocejas.cognitive.chatbot.framework.UseCase.None
import javax.inject.Inject

class ChatPresenter
@Inject constructor(private val startConversation: StartConversation, private val sendMessage: SendMessage) {

    internal lateinit var chatView: ChatView

    fun startConversation() {
        startConversation.execute(onSuccess(), None())
    }

    fun sendMessage(message: MessageViewModel) {
        renderMessage(message)

        val params = SendMessage.Params(Message(message.message, message.createdAt))
        sendMessage.execute(onSuccess(), params)
    }

    private fun onSuccess() = { outputMessage: Message -> renderMessage(MessageViewModel.from(outputMessage, RECEIVED)) }
    private fun renderMessage(message: MessageViewModel) = chatView.renderMessage(message)
}