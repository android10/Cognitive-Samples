package com.fernandocejas.cognitive.chatbot.chat

import com.google.gson.annotations.SerializedName

class MessageEntity(@SerializedName("output") val output: Output) {
//    class Input(@SerializedName("text") val text: String)
    class Output(@SerializedName("text") val text: List<String>)
//    data class Context(val conversation_id: String)
}