package com.eliasmazz.tipcalculator.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import com.eliasmazz.tipcalculator.R
import com.eliasmazz.tipcalculator.databinding.ActivityTipCalculatorBinding
import com.eliasmazz.tipcalculator.viewmodel.CalculatorViewModel

import kotlinx.android.synthetic.main.activity_tip_calculator.*

class TipCalculatorActivity : AppCompatActivity() {

    lateinit var binding: ActivityTipCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_tip_calculator)

        binding.vm = CalculatorViewModel()

        setSupportActionBar(binding.toolbar)

    }


}
