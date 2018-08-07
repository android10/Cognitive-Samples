package com.fernandocejas.kotlin.extension

fun Double.roundTwoDecimals(): Double {
    val factor = Math.pow(10.0, 2.0)
    return Math.round(this * factor) / factor
}

