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

class TipCalculatorActivity : AppCompatActivity(), SaveDialogFragment.Callback , LoadDialogFragment.Callback{

    lateinit var binding: ActivityTipCalculatorBinding

    override fun onSaveTip(name: String) {
        binding.vm?.saveCurrentTip(name)
        Snackbar.make(binding.root, "Saved $name", Snackbar.LENGTH_SHORT).show()
    }

    override fun onTipSelected(name: String) {
        Snackbar.make(binding.root, "Loaded $name", Snackbar.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save -> {
                showSaveDialog()
                true
            }
            R.id.action_load ->{
                showLoadDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showLoadDialog(){
        val loadDialogFragment = LoadDialogFragment()
        loadDialogFragment.show(supportFragmentManager, "LoadDialog")
    }

    private fun showSaveDialog() {
        val saveFragment = SaveDialogFragment()
        saveFragment.show(supportFragmentManager, "SaveDialog")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_tip_calculator)

        binding.vm = CalculatorViewModel(application)

        setSupportActionBar(binding.toolbar)

    }


}
