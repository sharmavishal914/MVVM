package com.vishal.kotlinmvvm.testing

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface


class TestViewModelFactory(var sessionManager: SessionManager, var requestInterface: RequestInterface) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TestViewModel::class.java)) {
            return TestViewModel(sessionManager,requestInterface) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel class");
    }
}