package com.fernandocejas.cognitive.chatbot.chat

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.fernandocejas.cognitive.chatbot.extension.inflate
import javax.inject.Inject
import kotlin.properties.Delegates

class ChatAdapter
@Inject constructor() : RecyclerView.Adapter<MessageViewHolder>() {

    internal var messages: List<MessageViewModel> by
            Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            MessageViewHolder.forViewType(parent.inflate(viewType), viewType)

    override fun onBindViewHolder(viewHolder: MessageViewHolder, position: Int) =
            viewHolder.bind(messages[position])

    override fun getItemViewType(position: Int) = messages[position].type.layoutRes

    override fun getItemCount() = messages.size
}