package com.eliasmazz.movilenext_day1_kotlin.model

import android.support.annotation.IdRes

data class ProgrammingLanguage(
    @IdRes
    val imageResourceId: Int,
    val title: String,
    val description: String,
    val year: Int
)