package com.eliasmazz.tipcalculator.viewmodel

import android.app.Application
import android.databinding.BaseObservable
import com.eliasmazz.tipcalculator.R
import com.eliasmazz.tipcalculator.model.Calculator
import com.eliasmazz.tipcalculator.model.TipCalculation

class CalculatorViewModel(val app: Application, val calculator: Calculator = Calculator()) :
    BaseObservable() {

    private val TAG = CalculatorViewModel::class.java.simpleName

    private var lastTipCalculated = TipCalculation()

    var inputCheckAmount = ""
    var inputTipPercentage = ""

    val outputCheckAmount get() = app.getString(R.string.dollar_amount, lastTipCalculated.checkAmount)
    val outputTipAmount get() = app.getString(R.string.dollar_amount, lastTipCalculated.tipAmount)
    val outputTotalDollarAmount get() = app.getString(R.string.dollar_amount, lastTipCalculated.grandTotal)
    val locationName get() = lastTipCalculated.locationName


    init {
        updateOutputs(TipCalculation())
    }

    private fun updateOutputs(tc: TipCalculation) {
        lastTipCalculated = tc
        notifyChange()
    }

    fun saveCurrentTip(name: String) {
        val tipToSave = lastTipCalculated.copy(locationName = name)
        calculator.saveTipCalculation(tipToSave)
        updateOutputs(tipToSave)

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