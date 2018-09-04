package com.vishal.kotlinmvvm.ui.login

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface

class LoginViewModelFactory(var sessionManager: SessionManager, var requestInterface: RequestInterface) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(sessionManager, requestInterface) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel class");
    }
}