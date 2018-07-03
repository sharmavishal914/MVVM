package com.vishal.kotlinmvvm.ui.login

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.vishal.kotlinmvvm.R
import com.vishal.kotlinmvvm.databinding.ActivityLoginBinding
import com.vishal.kotlinmvvm.ui.home.HomeActivity
import javax.inject.Inject

class LoginActivity : BaseActivity(), View.OnClickListener {

    @Inject
    lateinit var loginViewModelFactory: LoginViewModelFactory
    lateinit var loginViewModel: LoginViewModel
    lateinit var activityLoginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initialise()
    }

    private fun initialise() {
        loginViewModel = ViewModelProviders.of(this, loginViewModelFactory).get(LoginViewModel::class.java!!)
        // Binding UI
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        activityLoginBinding.loginViewModel = loginViewModel
        activityLoginBinding.setLifecycleOwner(this)

        initialiseToolBar("Login", false)
    }

    private fun callApi() {
        showLoading()
        loginViewModel.callApi()
    }



    override fun onClick(p: View?) {
        when (p!!.id) {
            R.id.btn_login -> {
                print(loginViewModel.email)
            }
        }
    }
}

