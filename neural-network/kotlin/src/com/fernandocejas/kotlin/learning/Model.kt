package com.fernandocejas.kotlin.learning

class Model {
    private val inputs = arrayOf(0.0, 1.0, 0.0, 0.0)
    private val weights = arrayOf(0.0, 0.0, 0.0, 0.0)

    fun execute() = evaluateNetwork(inputs, weights)

    private fun evaluateNetwork(inputs: Array<Double>, weights: Array<Double>) {
        var result = 0.0
        inputs.forEachIndexed { index, input -> result += (input * weights[index]) }
        println("Result: ${roundToDecimals(result, 2)}")
    }

    private fun roundToDecimals(number: Double, numDecimalPlaces: Int): Double {
        val factor = Math.pow(10.0, numDecimalPlaces.toDouble())
        return Math.round(number * factor) / factor
    }
}
