package com.fernandocejas.cognitive.chatbot.chat

import android.os.Bundle
import com.fernandocejas.cognitive.chatbot.BaseFragment
import com.fernandocejas.cognitive.chatbot.R
import javax.inject.Inject

class ChatFragment : BaseFragment(), ChatView {

    @Inject lateinit var chatPresenter: ChatPresenter
    @Inject lateinit var chatAdapter: ChatAdapter
    
    override fun layoutId() = R.layout.fragment_chat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
    }

    override fun renderMessage(message: MessageViewModel) = TODO()

    override fun dispose() = TODO()
}