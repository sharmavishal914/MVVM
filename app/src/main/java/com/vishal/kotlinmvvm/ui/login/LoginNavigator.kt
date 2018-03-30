package com.vishal.kotlinmvvm.ui.login

import com.vishal.kotlinmvvm.data.model.Model


interface LoginNavigator {
    fun openHomeScreen(model: Model)
}