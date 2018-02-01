package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.UnitTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class ChatPresenterTest : UnitTest() {

    private lateinit var chatPresenter: ChatPresenter

    @Mock private lateinit var chatView: ChatView
    @Mock private lateinit var sendMessage: SendMessage

    @Before fun setUp() {
        chatPresenter = ChatPresenter(sendMessage)
        chatPresenter.chatView = chatView
    }

    @Test fun `should render sent message`() {

    }

    @Test fun `should render response message`() {

    }
}