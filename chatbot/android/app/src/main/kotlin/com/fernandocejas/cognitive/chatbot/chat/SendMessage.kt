package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.chat.SendMessage.Params
import com.fernandocejas.cognitive.chatbot.framework.UseCase
import javax.inject.Inject

class SendMessage
@Inject constructor() : UseCase<Message, Params>() {

    override fun build(params: Params): Message = TODO()

    data class Params(val text: String)
}