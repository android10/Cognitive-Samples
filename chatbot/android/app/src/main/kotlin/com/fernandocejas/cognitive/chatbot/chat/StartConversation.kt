package com.fernandocejas.cognitive.chatbot.chat

import com.fernandocejas.cognitive.chatbot.framework.UseCase
import com.fernandocejas.cognitive.chatbot.framework.UseCase.None
import javax.inject.Inject

class StartConversation
@Inject constructor(private val chatDataSource: ChatDataSource) : UseCase<Message, None>() {

    override suspend fun run(params: None) = chatDataSource.startConversation()
}