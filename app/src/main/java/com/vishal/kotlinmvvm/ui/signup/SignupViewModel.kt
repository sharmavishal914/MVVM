package com.vishal.kotlinmvvm.ui.signup

import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import android.arch.lifecycle.MutableLiveData
import android.text.TextUtils
import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface

class SignupViewModel(var sessionManager: SessionManager, var requestInterface: RequestInterface) : ViewModel() {
    var signupNavigator: SignupNavigator? = null
    var isLoading = MutableLiveData<Boolean>()
    var first_name = MutableLiveData<String>()
    var last_name = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var confirm_password = MutableLiveData<String>()

}
