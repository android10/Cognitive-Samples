package com.fernandocejas.cognitive.chatbot.chat

import android.view.View
import com.fernandocejas.cognitive.chatbot.AndroidTest
import com.fernandocejas.cognitive.chatbot.chat.MessageViewHolder.MessageReceivedViewHolder
import com.fernandocejas.cognitive.chatbot.chat.MessageViewHolder.MessageSentViewHolder
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class MessageViewHolderTest: AndroidTest() {

    private lateinit var messageReceivedViewHolder: MessageReceivedViewHolder
    private lateinit var messageSentViewHolder: MessageSentViewHolder

    @Mock private lateinit var itemView: View

    @Before fun setUp() {
        messageReceivedViewHolder = MessageReceivedViewHolder(itemView)
        messageSentViewHolder = MessageSentViewHolder(itemView)
    }

    @Test fun `should create the right view holder type`() {
        val holderMessageSent = MessageViewHolder.forViewType(itemView,
                MessageViewModel.Type.SENT.layoutRes)
        val holderMessageReceived = MessageViewHolder.forViewType(itemView,
                MessageViewModel.Type.RECEIVED.layoutRes)

        holderMessageSent shouldBeInstanceOf MessageSentViewHolder::class.java
        holderMessageReceived shouldBeInstanceOf MessageReceivedViewHolder::class.java
    }

    @Test(expected = IllegalArgumentException::class) fun `should fail with wrong view type`() {
        MessageViewHolder.forViewType(itemView, 123)
    }
}