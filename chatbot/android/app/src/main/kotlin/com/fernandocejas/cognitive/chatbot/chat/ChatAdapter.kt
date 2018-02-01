package com.fernandocejas.cognitive.chatbot.chat

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.fernandocejas.cognitive.chatbot.R
import com.fernandocejas.cognitive.chatbot.chat.MessageViewModel.Type.RECEIVED
import com.fernandocejas.cognitive.chatbot.extension.inflate
import com.fernandocejas.cognitive.chatbot.util.DateTime
import javax.inject.Inject
import kotlin.properties.Delegates

class ChatAdapter
@Inject constructor(context: Context) : RecyclerView.Adapter<MessageViewHolder>() {

    private val initialValue =
            MessageViewModel(context.getString(R.string.welcome_message), DateTime.now(), RECEIVED)

    internal var messages: MutableList<MessageViewModel> by
            Delegates.observable(mutableListOf(initialValue)) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            MessageViewHolder.forViewType(parent.inflate(viewType), viewType)

    override fun onBindViewHolder(viewHolder: MessageViewHolder, position: Int) =
            viewHolder.bind(messages[position])

    override fun getItemViewType(position: Int) = messages[position].type.layoutRes

    override fun getItemCount() = messages.size
}