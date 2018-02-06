package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.AndroidTest
import com.fernandocejas.cognitive.chatbot.framework.UseCase.None
import com.fernandocejas.cognitive.chatbot.util.DateTime
import com.nhaarman.mockito_kotlin.verify
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class StartConversationTest : AndroidTest() {

    private lateinit var startConversation: StartConversation

    @Mock private lateinit var chatDataSource: ChatDataSource

    @Before
    fun setUp() {
        startConversation = StartConversation(chatDataSource)
    }

    @Test
    fun `should delegate message response to service`() {
        runBlocking { startConversation.execute({}, None()) }

        verify(chatDataSource).startConversation()
    }
}