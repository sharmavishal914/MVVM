package com.vishal.kotlinmvvm.ui.home.home

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface
import dagger.Module
import dagger.Provides

class HomeFragmentViewModelFactory(var sessionManager: SessionManager, var requestInterface: RequestInterface) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeFragmentViewModel::class.java)) {
            return HomeFragmentViewModel(sessionManager, requestInterface) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel class");
    }
}
