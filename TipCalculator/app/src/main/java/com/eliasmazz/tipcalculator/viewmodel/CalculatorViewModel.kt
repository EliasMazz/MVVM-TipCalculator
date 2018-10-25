package com.eliasmazz.tipcalculator.viewmodel

import android.util.Log
import com.eliasmazz.tipcalculator.model.RestaurantCalculator
import com.eliasmazz.tipcalculator.model.TipCalculation

class CalculatorViewModel(val calculator: RestaurantCalculator = RestaurantCalculator()) {

    private val TAG = CalculatorViewModel::class.java.simpleName
    var inputCheckAmount = ""
    var inputTipPercentage = ""
    var tipCalculation = TipCalculation()

    fun calculateTip() {

        Log.d(TAG,"calculateTipInvoked")

        val checkAmount = inputCheckAmount.toDoubleOrNull();
        val tipPct = inputTipPercentage.toIntOrNull()

        if (checkAmount != null && tipPct != null)
            tipCalculation = calculator.calculateTip(checkAmount, tipPct)

    }

}