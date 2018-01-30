package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.util.DateTime
import com.fernandocejas.cognitive.chatbot.framework.UseCase
import javax.inject.Inject

class WelcomeMessage
@Inject constructor() : UseCase<Message>() {
    override fun build() = Message("Hola, this is a test", DateTime.now())
}