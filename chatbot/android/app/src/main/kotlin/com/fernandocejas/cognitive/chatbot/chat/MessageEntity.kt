package com.fernandocejas.cognitive.chatbot.chat

class MessageEntity(val input: Input, val output: Output, val context: Context) {
    class Input(val text: String)
    class Output(val text: List<String>)
    class Context(val conversation_id: String)
}



