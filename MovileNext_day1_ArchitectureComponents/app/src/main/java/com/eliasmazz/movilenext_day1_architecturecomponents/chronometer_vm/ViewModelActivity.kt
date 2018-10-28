package com.eliasmazz.movilenext_day1_architecturecomponents


import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_live_data.*
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        val chronometerViewModel = ViewModelProviders.of(this).get(ChronometerViewModel::class.java)

        if(chronometerViewModel.startTime == 0L){
            val startTime = SystemClock.elapsedRealtime()
            chronometerViewModel.startTime = startTime
            l_chronometer.base = startTime
        }else{
            l_chronometer.base = chronometerViewModel.startTime
        }

        l_chronometer.start()

    }
}
