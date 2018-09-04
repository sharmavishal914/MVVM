package com.vishal.kotlinmvvm.ui.base

import android.arch.lifecycle.ViewModel
import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface

abstract class BaseViewModel<T>(var sessionManager: SessionManager, var requestInterface: RequestInterface) : ViewModel() {
    var mNavigator: T? = null
}
