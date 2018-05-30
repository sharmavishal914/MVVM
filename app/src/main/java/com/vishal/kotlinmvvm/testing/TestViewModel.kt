package com.vishal.kotlinmvvm.testing

import android.arch.lifecycle.ViewModel
import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface

class TestViewModel(var sessionManager: SessionManager, var requestInterface: RequestInterface) : ViewModel() {
    var scoreTeamA = 0

    fun getValue() = sessionManager.get("abc", "")


    fun update(){

    }


}