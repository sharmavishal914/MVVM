package com.vishal.kotlinmvvm.ui.login

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.vishal.kotlinmvvm.util.showLoadingDialog
import dagger.android.AndroidInjection
import android.view.inputmethod.InputMethodManager
import com.vishal.kotlinmvvm.util.isNetworkConnected


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


    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            if (imm != null) {
                imm!!.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }

    fun isNetworkConnected(): Boolean {
        return isNetworkConnected(applicationContext)
    }


}
