package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.AndroidTest
import com.fernandocejas.cognitive.chatbot.util.DateTime
import com.nhaarman.mockito_kotlin.verify
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class SendMessageTest : AndroidTest() {

    private lateinit var sendMessage: SendMessage

    @Mock private lateinit var chatApi: ChatCarTasks

    @Before fun setUp() {
        sendMessage = SendMessage(chatApi)
    }

    @Test fun `should get message result from api`() {
        val message = Message("test", DateTime.now())
        val params = SendMessage.Params(message)

        runBlocking { sendMessage.execute({}, params) }

        verify(chatApi).sendMessage(params.requestMessage)
    }
}