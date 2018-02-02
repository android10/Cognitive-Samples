package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.AndroidTest
import com.fernandocejas.cognitive.chatbot.R
import com.fernandocejas.cognitive.chatbot.chat.MessageViewModel.Type.RECEIVED
import com.fernandocejas.cognitive.chatbot.chat.MessageViewModel.Type.SENT
import com.fernandocejas.cognitive.chatbot.util.DateTime
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test

class ChatAdapterTest : AndroidTest() {

    private lateinit var chatAdapter: ChatAdapter

    @Before fun setUp() {
        chatAdapter = ChatAdapter(context())
    }

    @Test fun `should initialize with greeting message`() {
        chatAdapter.messages.size shouldBe 1
        chatAdapter.messages[0].message shouldBe context().getString(R.string.welcome_message)
    }

    @Test fun `item count should return message collection size`() {
        chatAdapter.messages = chatAdapter.messages
                .plus(MessageViewModel("Test 01", DateTime.now(), SENT))
                .plus(MessageViewModel("Test 02", DateTime.now(), RECEIVED))

        chatAdapter.itemCount shouldBe chatAdapter.messages.size
    }

    @Test fun `should return correct item view type`() {
        chatAdapter.messages = chatAdapter.messages
                .plus(MessageViewModel("Test 01", DateTime.now(), SENT))
                .plus(MessageViewModel("Test 02", DateTime.now(), RECEIVED))
                .plus(MessageViewModel("Test 02", DateTime.now(), RECEIVED))

        chatAdapter.getItemViewType(0) shouldEqual R.layout.item_message_received
        chatAdapter.getItemViewType(1) shouldEqual R.layout.item_message_sent
        chatAdapter.getItemViewType(2) shouldEqual R.layout.item_message_received
        chatAdapter.getItemViewType(3) shouldEqual R.layout.item_message_received

        chatAdapter.messages.size shouldBe 4
        chatAdapter.itemCount shouldBe 4
    }
}