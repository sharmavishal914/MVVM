package com.vishal.kotlinmvvm.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import dagger.android.support.AndroidSupportInjection


open class BaseFragment : Fragment() {
    lateinit var mActivity: BaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
    }

    private fun performDependencyInjection() {
        AndroidSupportInjection.inject(this)
    }

    override fun onAttach(context: Context?) {
        if (context is BaseActivity) {
            mActivity = context
        }
        super.onAttach(context)
    }

    fun isNetworkConnected(): Boolean {
        return  mActivity.isNetworkConnected()
    }

    fun hideKeyboard() {
         mActivity.hideKeyboard()
    }

    fun showToast(string: String) {
        mActivity.showToast(string)
    }

    fun updateToolbarHeading(string: String) {
         mActivity.updateToolbarHeading(string)
    }
    
}
