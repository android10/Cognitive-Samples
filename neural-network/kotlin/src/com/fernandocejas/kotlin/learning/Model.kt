package com.fernandocejas.kotlin.learning

class Model {
    private val inputs = arrayOf(0.0, 1.0, 0.0, 0.0)
    private val weights = arrayOf(0.0, 0.0, 0.0, 0.0)
    private val desiredResult = 1.0
    private val learningRate = 0.20

    fun execute() {
        println("Start Neural Net:")
        var neuralNetOutput = evaluateNeuralNet(inputs, weights)
        var neuralNetError = evaluateNeuralNetError(desiredResult, neuralNetOutput)

        println("Neural Net Output: $neuralNetOutput")
        println("Neural Net Error: $neuralNetError")
        println("Original weights vector: ${weights.contentToString()}")

        println("Learning Round 1:")
        learn(inputs, weights)
        neuralNetOutput = evaluateNeuralNet(inputs, weights)
        neuralNetError = evaluateNeuralNetError(desiredResult, neuralNetOutput)

        println("Neural Net Output: $neuralNetOutput")
        println("Neural Net Error: $neuralNetError")
        println("Weights vector learn Round 1: ${weights.contentToString()}")
    }

    private fun evaluateNeuralNet(inputs: Array<Double>, weights: Array<Double>): Double {
        var output = 0.0
        inputs.forEachIndexed { index, input -> output += (input * weights[index]) }
        return roundToDecimals(output, 2)
    }

    private fun evaluateNeuralNetError(desired: Double, actual: Double) =
            roundToDecimals(desired - actual, 2)

    private fun learn(inputs: Array<Double>, weights: Array<Double>) {
        weights.forEachIndexed { index, weight -> if (inputs[index] > 0) weights[index] = weight + learningRate }
    }

    private fun roundToDecimals(number: Double, numDecimalPlaces: Int): Double {
        val factor = Math.pow(10.0, numDecimalPlaces.toDouble())
        return Math.round(number * factor) / factor
    }
}