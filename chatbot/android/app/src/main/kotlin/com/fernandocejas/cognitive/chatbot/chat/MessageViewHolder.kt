package com.fernandocejas.cognitive.chatbot.chat

import android.support.v7.widget.RecyclerView
import android.view.View
//import kotlinx.android.synthetic.main.item_message_received.view.text_message
//import kotlinx.android.synthetic.main.item_message_sent.view.text_message

sealed class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun forViewType(itemView: View, viewType: Int): MessageViewHolder {
            when (viewType) {
                MessageViewModel.Type.SENT.layoutRes -> return MessageSentViewHolder(itemView)
                MessageViewModel.Type.RECEIVED.layoutRes -> return MessageReceivedViewHolder(itemView)
            }
            throw IllegalArgumentException("Invalid ViewHolder type")
        }
    }

    abstract fun bind(messageViewModel: MessageViewModel)

    internal class MessageSentViewHolder(itemView: View) : MessageViewHolder(itemView) {
        override fun bind(messageViewModel: MessageViewModel) {
//            itemView.text_message.text = messageViewModel.message
        }
    }

    internal class MessageReceivedViewHolder(itemView: View) : MessageViewHolder(itemView) {
        override fun bind(messageViewModel: MessageViewModel) {
//            itemView.text_message.text = messageViewModel.message
        }
    }
}