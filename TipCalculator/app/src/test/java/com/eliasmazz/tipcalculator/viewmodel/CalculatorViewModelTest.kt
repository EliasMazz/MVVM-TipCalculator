package com.eliasmazz.tipcalculator.viewmodel

import android.app.Application
import com.eliasmazz.tipcalculator.R
import com.eliasmazz.tipcalculator.model.RestaurantCalculator
import com.eliasmazz.tipcalculator.model.TipCalculation
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class CalculatorViewModelTest {

    lateinit var calculatorViewModel: CalculatorViewModel

    @Mock
    lateinit var mockRestaurantCalculator: RestaurantCalculator

    @Mock
    lateinit var application: Application

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        stubResource(0.0,"$0.00")
        calculatorViewModel = CalculatorViewModel(application,mockRestaurantCalculator)
    }

    private fun stubResource(given: Double, returnStub: String) {
        `when`(application.getString(R.string.dollar_amount,given)).thenReturn(returnStub)
    }

    @Test
    fun testCalculateTip() {
        calculatorViewModel.inputCheckAmount = "10.00"
        calculatorViewModel.inputTipPercentage = "15"


        val stub = TipCalculation(checkAmount = 10.00, tipAmount = 1.5, grandTotal = 11.5)
        `when`(mockRestaurantCalculator.calculateTip(10.00,15)).thenReturn(stub)


        stubResource(10.0,"$10.00")
        stubResource(1.5,"$1.50")
        stubResource(11.5,"$11.50")

        calculatorViewModel.calculateTip()


        assertEquals("$10.00", calculatorViewModel.outputCheckAmount)
        assertEquals("$1.50", calculatorViewModel.outputTipAmount)
        assertEquals("$11.50", calculatorViewModel.outputTotalDollarAmount)


    }

    @Test
    fun testCalculateTipBadTipPercentage(){
        calculatorViewModel.inputCheckAmount = "10.00"
        calculatorViewModel.inputTipPercentage = ""

        calculatorViewModel.calculateTip()

        verify(mockRestaurantCalculator, never()).calculateTip(ArgumentMatchers.anyDouble(), ArgumentMatchers.anyInt())
    }

    @Test
    fun testCalculateTipBadCheckAmount(){
        calculatorViewModel.inputCheckAmount = ""
        calculatorViewModel.inputTipPercentage = "15"

        calculatorViewModel.calculateTip()

        verify(mockRestaurantCalculator, never()).calculateTip(ArgumentMatchers.anyDouble(), ArgumentMatchers.anyInt())
    }
}