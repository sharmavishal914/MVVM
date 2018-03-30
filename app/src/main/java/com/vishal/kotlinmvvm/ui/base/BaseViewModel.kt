package com.vishal.kotlinmvvm.ui.login

import android.arch.lifecycle.ViewModel
import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface

open abstract class BaseViewModel<T>(var sessionManager: SessionManager, var requestInterface: RequestInterface) : ViewModel() {
    var mNavigator: T? = null
}
