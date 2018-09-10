package com.vishal.kotlinmvvm.ui.login

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.text.Html
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.emailValidator

import com.vishal.kotlinmvvm.R
import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.databinding.ActivityLoginBinding
import com.vishal.kotlinmvvm.ui.base.BaseActivity
import com.vishal.kotlinmvvm.ui.forgot.ForgotActivity
import com.vishal.kotlinmvvm.ui.home.HomeActivity
import com.vishal.kotlinmvvm.ui.signup.SignUpActivity
import com.vishal.kotlinmvvm.util.emptyStringIfNull
import com.vishal.kotlinmvvm.util.isTesting
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginNavigator {

    @Inject
    lateinit var loginViewModelFactory: LoginViewModelFactory
    lateinit var viewModel: LoginViewModel
    lateinit var activityLoginBinding: ActivityLoginBinding

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialise()
    }

    private fun initialise() {
        viewModel = ViewModelProviders.of(this, loginViewModelFactory).get(LoginViewModel::class.java)
        viewModel.loginNavigator = this
        // Binding UI
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        activityLoginBinding.viewModel = viewModel
        activityLoginBinding.navigator = this
        activityLoginBinding.setLifecycleOwner(this)
        initialiseToolBar("Login", false)

        val text = "<font color='#434343'>Don't have an account?</font> <font " + "color='#1976D2'>Register Now</font>."
        activityLoginBinding.txtRegisternow.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE)

        testingAccount()
    }

    private fun testingAccount() {
        if (!isTesting) return
        viewModel.email.value = "v@v.com"
        viewModel.password.value = "123456"
    }

    override fun onLoginClick() {
        if (viewModel.email.value.emptyStringIfNull().trim({ it <= ' ' }) == "") {
            showSnackBar(constraint_root, resources.getString(R.string.validation_email))
        } else if (!emailValidator(viewModel.email.value.emptyStringIfNull().trim({ it <= ' ' }))) {
            showSnackBar(constraint_root, resources.getString(R.string.validation_email_address))
        } else if (viewModel.password.value.emptyStringIfNull().trim({ it <= ' ' }) == "") {
            showSnackBar(constraint_root, resources.getString(R.string.validation_password))
        } else if (viewModel.password.value.emptyStringIfNull().trim({ it <= ' ' }).length < 6) {
            showSnackBar(constraint_root, resources.getString(R.string.validation_password_length))
        } else {
            if (isNetworkConnected()) {
                viewModel.callApi()
            } else {
                showSnackBar(constraint_root, "No Internet Connection")
            }
        }
    }

    override fun onForgotClick() {
        startActivity(Intent(applicationContext, ForgotActivity::class.java))
    }

    override fun onLoginResponse(boolean: Boolean, message: String) {
        startActivity(Intent(applicationContext, HomeActivity::class.java))
    }

    override fun onSignUpClick() {
        startActivity(Intent(applicationContext, SignUpActivity::class.java))
    }
}

