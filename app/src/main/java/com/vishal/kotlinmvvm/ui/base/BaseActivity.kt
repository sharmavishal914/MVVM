package com.vishal.kotlinmvvm.ui.login

import android.app.ProgressDialog
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.vishal.kotlinmvvm.util.showLoadingDialog
import dagger.android.AndroidInjection

open class BaseActivity : AppCompatActivity() {
    private var mProgressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDependencyInjection()
    }

    fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing()) {
            mProgressDialog!!.cancel()
        }
    }

    fun showLoading() {
        hideLoading()
        mProgressDialog = showLoadingDialog(this)
    }


    fun showToast(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }

    fun showSnackBar(view: View, message: String) = Snackbar
            .make(view, message, Snackbar.LENGTH_SHORT)
            .apply { show() }
}
