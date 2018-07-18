package com.vishal.kotlinmvvm.ui.home

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface
import com.vishal.kotlinmvvm.ui.login.LoginViewModel
import dagger.Module
import dagger.Provides

class HomeViewModelFactory(var sessionManager: SessionManager, var requestInterface: RequestInterface) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(sessionManager, requestInterface) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel class");
    }
}