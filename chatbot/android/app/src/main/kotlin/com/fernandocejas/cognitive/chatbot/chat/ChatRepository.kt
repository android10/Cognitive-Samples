package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.util.DateTime
import javax.inject.Inject

class ChatRepository
@Inject constructor() {

    fun sendMessage(message: Message): Message {
        //TODO: go to the network and get the response: use MessageEntity for Json parsing.
        return Message("TODO: reply from API", DateTime.now())
    }
}