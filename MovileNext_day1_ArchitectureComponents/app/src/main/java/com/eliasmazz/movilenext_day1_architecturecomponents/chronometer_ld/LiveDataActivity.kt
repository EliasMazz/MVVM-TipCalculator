package com.eliasmazz.movilenext_day1_architecturecomponents.chronometer_ld

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.eliasmazz.movilenext_day1_architecturecomponents.R
import kotlinx.android.synthetic.main.activity_live_data.*

class LiveDataActivity: AppCompatActivity (){


    private val liveDataTimerViewModel by lazy {
        ViewModelProviders.of(this).get(LiveDataTimerViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        subscribe()

    }

    private fun subscribe(){
        val elapsedTimeObserver = Observer<Long>{ time ->
            tvTimer.text = "$time segundos se passaram."
        }

        liveDataTimerViewModel.elapsedTime.observe(this,elapsedTimeObserver)
    }
}