package com.eliasmazz.tipcalculator.model

data class TipCalculation(
    val locationName: String = "",
    val checkAmount: Double = 0.0,
    val tipPctInput: Int = 0,
    val tipAmount: Double = 0.0,
    val grandTotal: Double = 0.0
)