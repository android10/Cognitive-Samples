package com.fernandocejas.kotlin.learning

class Model {
    private val inputs = arrayOf(0, 1, 0, 0)
    private val weights = arrayOf(0, 0, 0, 0)

    fun execute() = evaluateNetwork(inputs, weights)

    private fun evaluateNetwork(inputs: Array<Int>, weights: Array<Int>) {
        println("Hello World")
    }
}