package com.fernandocejas.cognitive.chatbot.framework

abstract class UseCase<out Type> where Type : Any {

    abstract fun build(): Type

    fun execute(onSuccess: (Type) -> Unit) {
        onSuccess.invoke(build())
    }
}