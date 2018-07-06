package com.vishal.kotlinmvvm.ui.login

import android.arch.lifecycle.ViewModel
import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.model.Model
import com.vishal.kotlinmvvm.data.remote.RequestInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import android.arch.lifecycle.MutableLiveData
import android.text.TextUtils
import com.vishal.kotlinmvvm.util.emailValidator


class LoginViewModel(var sessionManager: SessionManager, var requestInterface: RequestInterface) : ViewModel() {
    var loginNavigator: LoginNavigator? = null
    var isLoading_live = MutableLiveData<Boolean>()
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    fun onLoginClick() {
        loginNavigator!!.onLoginClick()
    }

    fun callApi() {
        isLoading_live.value = true
        requestInterface.getServiceIP()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError)
    }

    private fun handleResponse(model: Model) {
        isLoading_live.value = false
        loginNavigator!!.onLoginResponse(true, "")
    }

    private fun handleError(error: Throwable) {
        error.printStackTrace()
        isLoading_live.value = false
    }

    fun isValidData(): String {
        if (TextUtils.isEmpty(email.value)) {
            return "Please enter email address"
        }
        if (!emailValidator(email.value!!)) {
            return "Enter valid email address"
        }
        if (TextUtils.isEmpty(password.value)) {
            return "Please enter password"
        }
        return ""
    }
}
