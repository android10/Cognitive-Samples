package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.chat.SendMessage.Params
import com.fernandocejas.cognitive.chatbot.framework.UseCase
import javax.inject.Inject
import javax.inject.Named

class SendMessage
@Inject constructor(@Named(ChatModule.API_CAR_TASKS) private val chatApi: ChatApi) :
        UseCase<Message, Params>() {

    override suspend fun run(params: Params): Message =
            chatApi.sendMessage(params.requestMessage)

    data class Params(val requestMessage: Message)
}