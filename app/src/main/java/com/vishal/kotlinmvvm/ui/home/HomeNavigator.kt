package com.vishal.kotlinmvvm.ui.home

import com.vishal.kotlinmvvm.data.model.Model


interface HomeNavigator {
    fun openHomeScreen(model: Model)
}