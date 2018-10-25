package com.eliasmazz.tipcalculator.viewmodel

import android.app.Application
import android.databinding.BaseObservable
import android.util.Log
import com.eliasmazz.tipcalculator.R
import com.eliasmazz.tipcalculator.model.RestaurantCalculator
import com.eliasmazz.tipcalculator.model.TipCalculation

class CalculatorViewModel(val app: Application, val calculator: RestaurantCalculator = RestaurantCalculator()) : BaseObservable() {

    private val TAG = CalculatorViewModel::class.java.simpleName
    var inputCheckAmount = ""
    var inputTipPercentage = ""

    var outputCheckAmount = ""
    var outputTipAmount = ""
    var outputTotalDollarAmount = ""

    init {
        updateOutputs(TipCalculation())
    }

    private fun updateOutputs(tc: TipCalculation){
        outputCheckAmount = app.getString(R.string.dollar_amount,tc.checkAmount)
        outputTipAmount = app.getString(R.string.dollar_amount,tc.tipAmount)
        outputTotalDollarAmount = app.getString(R.string.dollar_amount,tc.grandTotal)
    }

    fun calculateTip() {

        //Log.d(TAG, "calculateTipInvoked")

        val checkAmount = inputCheckAmount.toDoubleOrNull();
        val tipPct = inputTipPercentage.toIntOrNull()

        if (checkAmount != null && tipPct != null) {

            //Log.d(TAG, "CheckAmount: $checkAmount, TipPercentage: $tipPct")
            updateOutputs(calculator.calculateTip(checkAmount, tipPct))
            cleanInputs()
        }

    }

    fun cleanInputs() {
        inputCheckAmount = "0.00"
        inputTipPercentage = "0"
        notifyChange()
    }

}