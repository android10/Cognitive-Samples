package com.fernandocejas.cognitive.chatbot.chat

import android.support.annotation.LayoutRes
import com.fernandocejas.cognitive.chatbot.R

data class MessageViewModel(val message: String, val createdAt: String, val type: Type) {

    enum class Type(@LayoutRes val layoutRes: Int) {
        SENT(R.layout.item_message_sent),
        RECEIVED (R.layout.item_message_received);
    }
}
