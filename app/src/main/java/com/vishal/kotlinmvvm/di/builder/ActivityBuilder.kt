package com.vishal.kotlinmvvm.di.builder

import com.vishal.chat.ui.home.home.HomeFragment
import com.vishal.chat.ui.home.home.HomeFragmentModule
import com.vishal.kotlinmvvm.ui.home.HomeActivity
import com.vishal.kotlinmvvm.ui.home.HomeActivityModule
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
    @ContributesAndroidInjector()
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = arrayOf(LoginActivityModule::class))
    internal abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = arrayOf(HomeActivityModule::class))
    internal abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = arrayOf(HomeFragmentModule::class))
    internal abstract fun bindHomeFragment(): HomeFragment

}