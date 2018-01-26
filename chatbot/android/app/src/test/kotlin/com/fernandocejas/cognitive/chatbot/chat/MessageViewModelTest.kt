package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.R
import com.fernandocejas.cognitive.chatbot.UnitTest
import org.amshove.kluent.shouldEqual
import org.junit.Test

class MessageViewModelTest: UnitTest() {

    @Test fun `should return correct message type`() {
        val messageTypeReceived = MessageViewModel.Type.RECEIVED
        val messageTypeSent = MessageViewModel.Type.SENT

        messageTypeReceived.layoutRes shouldEqual R.layout.item_message_received
        messageTypeSent.layoutRes shouldEqual R.layout.item_message_sent
    }
}