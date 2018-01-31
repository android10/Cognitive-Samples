package com.fernandocejas.cognitive.chatbot.chat

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.fernandocejas.cognitive.chatbot.R
import com.fernandocejas.cognitive.chatbot.extension.empty
import com.fernandocejas.cognitive.chatbot.framework.BaseFragment
import kotlinx.android.synthetic.main.fragment_chat.btn_send
import kotlinx.android.synthetic.main.fragment_chat.rv_chat
import kotlinx.android.synthetic.main.fragment_chat.txt_message
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
        if (firstTimeCreated(savedInstanceState)) initializeView()
    }

    private fun initializeView() {
        rv_chat.layoutManager = LinearLayoutManager(activity)
        rv_chat.adapter = chatAdapter
        chatPresenter.chatView = this
        btn_send.setOnClickListener {
            val message = txt_message.text.toString().trim()
            if (message != String.empty()) {
                sendMessage(message)
                txt_message.text.clear()
            }
        }
    }

    private fun sendMessage(text: String) = chatPresenter.sendMessage(text)

    override fun renderMessage(message: MessageViewModel) {
        chatAdapter.messages.add(message)
        //TODO: this should not go here: refactor
        chatAdapter.notifyDataSetChanged()
    }

    override fun context(): Context = context!!.applicationContext
}