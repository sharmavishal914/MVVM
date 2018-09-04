package com.vishal.kotlinmvvm.ui.base

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.Toast
import dagger.android.AndroidInjection
import android.view.inputmethod.InputMethodManager
import com.vishal.kotlinmvvm.util.isNetworkConnected
import kotlinx.android.synthetic.main.toolbar.*


open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDependencyInjection()
    }

    fun performDependencyInjection() {
        AndroidInjection.inject(this)
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
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun isNetworkConnected(): Boolean {
        return isNetworkConnected(applicationContext)
    }

    fun initialiseToolBar(title: String, isBack: Boolean) {
        setSupportActionBar(toolbar);
        getSupportActionBar()!!.setTitle("");
        toolbar_title.setText(title)

        if (title.equals("HomeFragment")) {

        } else {
            if (isBack) {
                getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true);
                getSupportActionBar()!!.setHomeButtonEnabled(true);

                toolbar.setNavigationOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        onBackPressed() // Implemented by activity
                    }
                })
            }
        }
    }

    fun updateToolbarHeading(title: String) {
        toolbar_title.setText(title)
    }

}
