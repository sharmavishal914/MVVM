package com.vishal.kotlinmvvm.ui.forgot

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface

class ForgotViewModel(var sessionManager: SessionManager, var requestInterface: RequestInterface) : ViewModel() {
    var forgotNavigator: ForgotNavigator? = null
    var email = MutableLiveData<String>()
    var isLoading = MutableLiveData<Boolean>()
}