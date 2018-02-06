package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.UnitTest
import com.fernandocejas.cognitive.chatbot.util.DateTime
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.verify
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class ChatDataSourceTest : UnitTest() {

    private val TEXT_INPUT = "Test Input"
    private val TEXT_OUTPUT = "Test Output"
    private val MESSAGE_ENTITY = MessageEntity(TEXT_INPUT, listOf(TEXT_OUTPUT))

    private lateinit var chatDataSource: ChatDataSource

    @Mock private lateinit var chatService: ChatService

    @Before fun setUp() {
        given(chatService.startConversation()).willReturn(MESSAGE_ENTITY)
        given(chatService.sendMessage(any())).willReturn(MESSAGE_ENTITY)
        chatDataSource = ChatDataSource(chatService)
    }

    @Test fun `should delegate conversation start to chat service`() {
        val message = chatDataSource.startConversation()

        message.text shouldEqual TEXT_OUTPUT
        verify(chatService).startConversation()
    }

    @Test fun `should delegate message send to chat service`() {
        val inputMessage = Message("test", DateTime.now())
        val message = chatDataSource.sendMessage(inputMessage)

        message.text shouldEqual TEXT_OUTPUT
        verify(chatService).sendMessage(inputMessage)
    }
}