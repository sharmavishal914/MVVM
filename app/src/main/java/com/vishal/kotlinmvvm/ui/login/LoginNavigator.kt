package com.vishal.kotlinmvvm.ui.login

interface LoginNavigator {
    fun onLoginClick()
    fun onLoginResponse(boolean: Boolean, string: String)
}