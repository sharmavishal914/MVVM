package com.vishal.kotlinmvvm.ui.home.list

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface
import dagger.Module
import dagger.Provides

class ListViewModelFactory(var sessionManager: SessionManager, var requestInterface: RequestInterface) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(sessionManager, requestInterface) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel class");
    }
}
