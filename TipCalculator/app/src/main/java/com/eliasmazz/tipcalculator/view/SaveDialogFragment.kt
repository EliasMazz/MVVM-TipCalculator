package com.eliasmazz.tipcalculator.view

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.View
import android.widget.EditText
import com.eliasmazz.tipcalculator.R

class SaveDialogFragment : DialogFragment() {


    interface Callback {
        fun onSaveTip(name: String)
    }

    private var saveTipCallBack: SaveDialogFragment.Callback? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        saveTipCallBack = context as? Callback
    }

    override fun onDetach() {
        super.onDetach()
        saveTipCallBack = null
    }



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // let sent itself inside the expression and can be used to change it..
        val saveDialog = context?.let { ctx ->
            val editText = EditText(ctx)
            editText.id = viewId
            editText.hint = getString(R.string.save_hint)
            AlertDialog.Builder(ctx)
                .setView(editText)
                .setNegativeButton(getString(R.string.action_cancel), null)
                .setPositiveButton(getString(R.string.action_save), { _, _ -> onSave(editText) })
                .create()
        }

        return saveDialog!!
    }

    private fun onSave(editText: EditText) {
        val text = editText.text.toString()
        if (text.isNotEmpty()) {
            saveTipCallBack?.onSaveTip(text)
        }
    }

    //static
    companion object {
        val viewId = View.generateViewId()
    }
}