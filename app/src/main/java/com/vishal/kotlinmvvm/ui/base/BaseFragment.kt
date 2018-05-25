package com.vishal.kotlinmvvm.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection


open class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
    }

    private fun performDependencyInjection() {
        AndroidSupportInjection.inject(this)
    }

}
