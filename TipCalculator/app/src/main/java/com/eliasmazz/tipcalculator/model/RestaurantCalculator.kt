package com.eliasmazz.tipcalculator.model

import java.math.RoundingMode

class RestaurantCalculator {
    fun calculateTip(checkAmount: Double, tipPctInput: Int): TipCalculation {
        val tipAmount = (checkAmount * (tipPctInput.toDouble() / 100.0))
            .toBigDecimal()
            .setScale(2,RoundingMode.HALF_UP)
            .toDouble()

        val grandTotal = checkAmount + tipAmount

        return TipCalculation(
            checkAmount = checkAmount,
            tipPctInput = tipPctInput,
            tipAmount = tipAmount,
            grandTotal = grandTotal
        )
    }
}