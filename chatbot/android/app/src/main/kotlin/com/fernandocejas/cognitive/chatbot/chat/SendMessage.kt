package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.chat.SendMessage.Params
import com.fernandocejas.cognitive.chatbot.framework.UseCase
import javax.inject.Inject

class SendMessage
@Inject constructor(private val chatDataSource: ChatDataSource) : UseCase<Message, Params>() {

    override suspend fun run(params: Params) = chatDataSource.sendMessage(params.requestMessage)

    data class Params(val requestMessage: Message)
}