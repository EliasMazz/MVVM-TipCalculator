package com.eliasmazz.tipcalculator.view

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.widget.DividerItemDecoration
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import com.eliasmazz.tipcalculator.R
import kotlinx.android.synthetic.main.saved_tip_calculations_list.view.*

class LoadDialogFragment : DialogFragment() {


    interface Callback {
        fun onTipSelected(name: String)
    }

    private var loadTipCallBack: LoadDialogFragment.Callback? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        loadTipCallBack = context as? Callback
    }

    override fun onDetach() {
        super.onDetach()
        loadTipCallBack = null
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // let sent itself inside the expression and can be used to change it..
        val dialog = context?.let { ctx ->

            AlertDialog.Builder(ctx)
                .setView(createView(ctx))
                .setNegativeButton(R.string.action_cancel, null)
                .create()
        }

        return dialog!!
    }

    private fun createView(ctx: Context): View {

        val rv = LayoutInflater
            .from(ctx)
            .inflate(R.layout.saved_tip_calculations_list, null)
            .recycler_saved_calculation

        rv.setHasFixedSize(true)
        rv.addItemDecoration(DividerItemDecoration(ctx, DividerItemDecoration.VERTICAL))
        return rv
    }
    /*
   private fun onSelect(editText: EditText) {
       val text = editText.text.toString()
       if (text.isNotEmpty()) {
           loadTipCallBack?.onTipSelected(text)
       }
   }
   */

    //static
    companion object {
        val viewId = View.generateViewId()
    }
}