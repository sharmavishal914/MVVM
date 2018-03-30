package com.vishal.kotlinmvvm.util

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.vishal.kotlinmvvm.R

/**
 * Created by Administrator on 3/26/2018.
 */

fun showLoadingDialog(context: Context): ProgressDialog {
    val progressDialog = ProgressDialog(context)
    progressDialog.show()
    if (progressDialog.window != null) {
        progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
    progressDialog.setContentView(R.layout.progress_dialog)
    progressDialog.isIndeterminate = true
    progressDialog.setCancelable(false)
    progressDialog.setCanceledOnTouchOutside(false)
    return progressDialog
}
