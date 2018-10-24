package com.eliasmazz.tipcalculator.viewmodel

import com.eliasmazz.tipcalculator.model.RestaurantCalculator
import com.eliasmazz.tipcalculator.model.TipCalculation

class CalculatorViewModel(val calculator: RestaurantCalculator = RestaurantCalculator()) {

    var inputCheckAmount = ""
    var inputTipPercentage = ""
    var tipCalculation = TipCalculation()

    fun calculateTip() {

        val checkAmount = inputCheckAmount.toDoubleOrNull();
        val tipPct = inputTipPercentage.toIntOrNull()

        if (checkAmount != null && tipPct != null)
            calculator.calculateTip(checkAmount, tipPct)
        
    }

}