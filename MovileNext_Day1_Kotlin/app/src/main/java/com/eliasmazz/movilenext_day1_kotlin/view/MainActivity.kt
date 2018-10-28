package com.eliasmazz.movilenext_day1_kotlin.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.eliasmazz.movilenext_day1_kotlin.R
import com.eliasmazz.movilenext_day1_kotlin.adapter.ProgrammingLanguageAdapter
import com.eliasmazz.movilenext_day1_kotlin.model.ProgrammingLanguage
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = ProgrammingLanguageAdapter(
            recyclerViewItems(),
            this){
            longToast("Clicked item: ${it.title}")
        }

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)



    }

    private fun recyclerViewItems(): List<ProgrammingLanguage> {
        val kotlin = ProgrammingLanguage(
            R.drawable.kotlin,
            "kotlin",
            "Kotlin é uma linguagem de programação",
            2010)


        return listOf(kotlin,kotlin)
    }
}


