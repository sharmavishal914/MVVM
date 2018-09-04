package com.vishal.kotlinmvvm.ui.login

import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import android.arch.lifecycle.MutableLiveData
import android.text.TextUtils
import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.model.Model
import com.vishal.kotlinmvvm.data.remote.RequestInterface


class LoginViewModel(var sessionManager: SessionManager, var requestInterface: RequestInterface) : ViewModel() {
    var loginNavigator: LoginNavigator? = null
    var isLoading = MutableLiveData<Boolean>()
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    fun callApi() {
        isLoading.value = true
        requestInterface.getServiceIP()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError)
    }

    private fun handleResponse(model: Model) {
        isLoading.value = false
        loginNavigator!!.onLoginResponse(true, "")
    }

    private fun handleError(error: Throwable) {
        error.printStackTrace()
        isLoading.value = false

        // Remove this as its for testing :)
        loginNavigator!!.onLoginResponse(true, "")
    }

}
