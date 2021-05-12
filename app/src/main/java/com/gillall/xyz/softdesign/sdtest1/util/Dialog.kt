package com.gillall.xyz.softdesign.sdtest1.util

import android.app.Dialog
import android.content.Context

object Dialog {

    fun dialogCreate(c: Context, resid: Int, cancelable: Boolean): Dialog {
        val dialog = Dialog(c)
        //dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(resid)
        dialog.setCancelable(cancelable)
        return dialog
    }
}