package com.vishal.kotlinmvvm.di.builder


import com.vishal.kotlinmvvm.ui.forgot.ForgotActivity
import com.vishal.kotlinmvvm.ui.home.HomeActivity
import com.vishal.kotlinmvvm.ui.home.home.HomeFragment
import com.vishal.kotlinmvvm.ui.home.list.ListFragment
import com.vishal.kotlinmvvm.ui.login.LoginActivity
import com.vishal.kotlinmvvm.ui.signup.SignUpActivity
import com.vishal.kotlinmvvm.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module

abstract class ActivityBuilder {
    @ContributesAndroidInjector()
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = arrayOf())
    internal abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = arrayOf())
    internal abstract fun bindForgotActivity(): ForgotActivity

    @ContributesAndroidInjector(modules = arrayOf())
    internal abstract fun bindSignUpActivity(): SignUpActivity

    @ContributesAndroidInjector(modules = arrayOf())
    internal abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = arrayOf())
    internal abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = arrayOf())
    internal abstract fun bindListFragment(): ListFragment


}