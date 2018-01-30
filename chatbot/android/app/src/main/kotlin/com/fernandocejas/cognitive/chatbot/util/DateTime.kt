package com.fernandocejas.cognitive.chatbot.util

class DateTime private constructor() {
    companion object {
        fun now(): DateTime = DateTime()
    }

    //TODO
    fun time(): String { return "10:30 PM" }
}