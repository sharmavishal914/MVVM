package com.vishal.kotlinmvvm.ui.login

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.vishal.kotlinmvvm.R
import com.vishal.kotlinmvvm.databinding.ActivityLoginBinding
import com.vishal.kotlinmvvm.ui.home.HomeActivity
import com.vishal.kotlinmvvm.util.isTesting
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginNavigator {

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
        loginViewModel.loginNavigator = this
        // Binding UI
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        activityLoginBinding.loginViewModel = loginViewModel
        activityLoginBinding.setLifecycleOwner(this)
        initialiseToolBar("Login", false)

        testingAccount()
    }

    private fun testingAccount() {
        if (!isTesting) return
        loginViewModel.email.value = "v@v.com"
        loginViewModel.password.value = "123456"
    }

    override fun onLoginClick() {
        if (isNetworkConnected()) {
            if (!loginViewModel.isValidData().equals("")) {
                showSnackBar(constraint_root, loginViewModel.isValidData())
            } else {
                loginViewModel.callApi()
            }
        } else {
            showSnackBar(constraint_root, "No Internet Connection")
        }
    }

    override fun onLoginResponse(boolean: Boolean, message: String) {
        startActivity(Intent(applicationContext, HomeActivity::class.java))
    }
}

