package com.fernandocejas.cognitive.chatbot.chat

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.fernandocejas.cognitive.chatbot.BaseFragment
import com.fernandocejas.cognitive.chatbot.R
import kotlinx.android.synthetic.main.fragment_chat.rv_chat
import javax.inject.Inject

class ChatFragment : BaseFragment(), ChatView {

    @Inject lateinit var chatPresenter: ChatPresenter
    @Inject lateinit var chatAdapter: ChatAdapter

    override fun layoutId() = R.layout.fragment_chat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        if (firstTimeCreated(savedInstanceState)) welcomeMessage()
    }

    private fun initializeView() {
        rv_chat.layoutManager = LinearLayoutManager(activity)
        rv_chat.adapter = chatAdapter
        chatPresenter.chatView = this
    }

    private fun welcomeMessage() = chatPresenter.sayHi()

    override fun renderMessage(message: MessageViewModel) {
        chatAdapter.messages.add(message)
    }
}