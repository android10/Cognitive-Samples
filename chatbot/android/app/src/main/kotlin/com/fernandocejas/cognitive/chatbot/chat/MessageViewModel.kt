package com.fernandocejas.cognitive.chatbot.chat

import android.support.annotation.LayoutRes
import com.fernandocejas.cognitive.chatbot.R
import com.fernandocejas.cognitive.chatbot.util.DateTime

data class MessageViewModel(val message: String, val createdAt: DateTime, val type: Type) {

    companion object {
        fun from(message: Message, type: Type) =
                MessageViewModel(message.text, message.createdAt, type)
    }

    enum class Type(@LayoutRes val layoutRes: Int) {
        SENT(R.layout.item_message_sent),
        RECEIVED (R.layout.item_message_received);
    }
}
