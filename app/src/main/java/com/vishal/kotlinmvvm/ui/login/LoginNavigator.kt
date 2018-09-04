package com.vishal.kotlinmvvm.ui.login

interface LoginNavigator {
    fun onLoginClick()
    fun onLoginResponse(boolean: Boolean, message: String)
    fun onForgotClick()
    fun onSignUpClick()
}