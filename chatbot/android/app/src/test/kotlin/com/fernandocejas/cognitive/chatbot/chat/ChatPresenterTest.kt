package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.UnitTest
import com.fernandocejas.cognitive.chatbot.chat.MessageViewModel.Type.SENT
import com.fernandocejas.cognitive.chatbot.framework.UseCase.None
import com.fernandocejas.cognitive.chatbot.util.DateTime
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class ChatPresenterTest : UnitTest() {

    private lateinit var chatPresenter: ChatPresenter

    @Mock private lateinit var chatView: ChatView
    @Mock private lateinit var startConversation: StartConversation
    @Mock private lateinit var sendMessage: SendMessage

    @Before fun setUp() {
        chatPresenter = ChatPresenter(startConversation, sendMessage)
        chatPresenter.chatView = chatView
    }

    @Test fun `should execute StartConversation use case and render response message`() {
        chatPresenter.startConversation()

        verify(startConversation).execute(any(), any())
    }

    @Test fun `should render sent message`() {
        val message = MessageViewModel("Test", DateTime.now(), SENT)
        chatPresenter.sendMessage(message)

        verify(chatView).renderMessage(message)
    }

    @Test fun `should execute SendMessage use case and render response message`() {
        val message = MessageViewModel("Test", DateTime.now(), SENT)
        chatPresenter.sendMessage(message)

        val params = SendMessage.Params(Message(message.message, message.createdAt))

        verify(sendMessage).execute(any(), eq(params))
        verify(chatView).renderMessage(message)
        verify(chatView).renderMessage(any())
    }
}