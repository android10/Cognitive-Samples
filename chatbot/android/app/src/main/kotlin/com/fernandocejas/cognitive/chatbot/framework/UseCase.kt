package com.fernandocejas.cognitive.chatbot.framework

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract fun build(params: Params): Type

    fun execute(onSuccess: (Type) -> Unit, params: Params) {
        val result = build(params)
        onSuccess.invoke(result)
    }
}