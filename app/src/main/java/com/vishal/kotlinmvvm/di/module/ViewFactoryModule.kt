package com.vishal.kotlinmvvm.di.module

import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface
import com.vishal.kotlinmvvm.ui.home.HomeViewModelFactory
import com.vishal.kotlinmvvm.ui.login.LoginViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewFactoryModule {

    @Provides
    fun provideLoginViewModelFactory(sessionManager: SessionManager, requestInterface: RequestInterface): LoginViewModelFactory {
        return LoginViewModelFactory(sessionManager, requestInterface)
    }

    @Provides
    fun provideHomeViewModelFactory(sessionManager: SessionManager, requestInterface: RequestInterface): HomeViewModelFactory {
        return HomeViewModelFactory(sessionManager, requestInterface)
    }

}