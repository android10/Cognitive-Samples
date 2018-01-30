package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.framework.UseCase
import javax.inject.Inject

class SendMessage
@Inject constructor() : UseCase<Message>() {
    override fun build(): Message = TODO()
}