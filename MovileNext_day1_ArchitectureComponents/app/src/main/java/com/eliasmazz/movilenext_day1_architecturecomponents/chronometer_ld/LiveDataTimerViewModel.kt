package com.eliasmazz.movilenext_day1_architecturecomponents.chronometer_ld

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.SystemClock
import java.io.File
import java.util.*

class LiveDataTimerViewModel : ViewModel() {
    val elapsedTime = MutableLiveData<Long>()

    companion object {
        const val ONE_SECOND = 1000L
    }

    init {
        val initialTime = SystemClock.elapsedRealtime()
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - initialTime) / 1000
                elapsedTime.postValue(newValue)

            }

        }, ONE_SECOND, ONE_SECOND)
    }
}