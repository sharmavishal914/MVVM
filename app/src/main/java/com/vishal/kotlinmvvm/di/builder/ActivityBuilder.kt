package com.vishal.kotlinmvvm.di.builder

import com.vishal.kotlinmvvm.ui.login.LoginActivity
import com.vishal.kotlinmvvm.ui.login.LoginActivityModule
import com.vishal.kotlinmvvm.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Administrator on 1/15/2018.
 */
@Module

abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = arrayOf(LoginActivityModule::class))
    internal abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector()
    internal abstract fun bindSplashActivity(): SplashActivity
}