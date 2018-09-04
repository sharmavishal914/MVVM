package com.vishal.kotlinmvvm.ui.home

import android.arch.lifecycle.MutableLiveData
import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.model.Model
import com.vishal.kotlinmvvm.data.remote.RequestInterface
import com.vishal.kotlinmvvm.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(sessionManager: SessionManager, requestInterface: RequestInterface) : BaseViewModel<HomeNavigator>(sessionManager, requestInterface) {

    var email = MutableLiveData<String>()

    fun callApi() {
        requestInterface.getServiceIP()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError)
    }

    private fun handleResponse(model: Model) {
        mNavigator!!.openHomeScreen(model)
    }

    private fun handleError(error: Throwable) {
        error.printStackTrace()
    }
}
