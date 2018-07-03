package com.vishal.kotlinmvvm.ui.login

import android.arch.lifecycle.ViewModel
import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.model.Model
import com.vishal.kotlinmvvm.data.remote.RequestInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import android.arch.lifecycle.MutableLiveData
import android.databinding.*
import android.databinding.PropertyChangeRegistry
import com.vishal.kotlinmvvm.BR
import kotlin.properties.Delegates


class LoginViewModel(var sessionManager: SessionManager, var requestInterface: RequestInterface) : ViewModel(), Observable {
    private val registry = PropertyChangeRegistry()

    @get:Bindable
    var email: String by Delegates.observable("") { prop, old, new ->
        registry.notifyChange(this, BR.email)
    }

    @get:Bindable
    var password: String by Delegates.observable("") { prop, old, new ->
        registry.notifyChange(this, BR.password)
    }

    fun callApi() {
        requestInterface.getServiceIP()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError)
    }

    private fun handleResponse(model: Model) {

    }

    private fun handleError(error: Throwable) {
        error.printStackTrace()
    }


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        registry.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        registry.remove(callback)
    }
}
