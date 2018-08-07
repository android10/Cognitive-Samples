package com.fernandocejas.kotlin.learning

import com.fernandocejas.kotlin.extension.roundTwoDecimals

class Model {
    private val inputs = arrayOf(0.0, 1.0, 0.0, 0.0)
    private val weights = arrayOf(0.0, 0.0, 0.0, 0.0)
    private val desiredResult = 1.0
    private val learningRate = 0.20
    private val learningTrials = 5

    fun train() {
        printNeuralNetworkInfo(inputs, weights)
        for (i in 1..learningTrials) learn(inputs, weights)
        printNeuralNetworkInfo(inputs, weights)
    }

    private fun learn(inputs: Array<Double>, weights: Array<Double>) {
        weights.forEachIndexed { index, weight -> if (inputs[index] > 0) weights[index] = weight + learningRate }
    }

    private fun evaluateNeuralNet(inputs: Array<Double>, weights: Array<Double>): Double {
        var output = 0.0
        inputs.forEachIndexed { index, input -> output += (input * weights[index]) }
        return output.roundTwoDecimals()
    }

    private fun evaluateNeuralNetError(desired: Double, actual: Double) =
            (desired - actual).roundTwoDecimals()

    private fun printNeuralNetworkInfo(inputs: Array<Double>, weights: Array<Double>) {
        val neuralNetOutput = evaluateNeuralNet(inputs, weights)
        val neuralNetError = evaluateNeuralNetError(desiredResult, neuralNetOutput)

        println("Neural Net Output: $neuralNetOutput")
        println("Neural Net Error: $neuralNetError")
        println("Weights vector: ${weights.contentToString()}\n")
    }
}