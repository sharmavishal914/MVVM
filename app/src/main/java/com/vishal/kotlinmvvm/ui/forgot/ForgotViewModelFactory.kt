package com.vishal.kotlinmvvm.ui.forgot

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface

class ForgotViewModelFactory (var sessionManager: SessionManager, var requestInterface: RequestInterface) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ForgotViewModel::class.java)) {
            return ForgotViewModel(sessionManager, requestInterface) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel class");
    }
}