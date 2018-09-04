package com.vishal.kotlinmvvm.di.module


import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface
import com.vishal.kotlinmvvm.ui.forgot.ForgotViewModelFactory
import com.vishal.kotlinmvvm.ui.home.HomeViewModelFactory
import com.vishal.kotlinmvvm.ui.home.home.HomeFragmentViewModelFactory
import com.vishal.kotlinmvvm.ui.home.list.ListViewModelFactory
import com.vishal.kotlinmvvm.ui.login.LoginViewModelFactory
import com.vishal.kotlinmvvm.ui.signup.SignupViewModelFactory
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

    @Provides
    fun provideForgotViewModelFactory(sessionManager: SessionManager, requestInterface: RequestInterface): ForgotViewModelFactory {
        return ForgotViewModelFactory(sessionManager, requestInterface)
    }

    @Provides
    fun provideSignupViewModelFactory(sessionManager: SessionManager, requestInterface: RequestInterface): SignupViewModelFactory {
        return SignupViewModelFactory(sessionManager, requestInterface)
    }

    @Provides
    fun provideHomeFragmentViewModelFactory(sessionManager: SessionManager, requestInterface: RequestInterface): HomeFragmentViewModelFactory {
        return HomeFragmentViewModelFactory(sessionManager, requestInterface)
    }

    @Provides
    fun provideListViewModelFactory(sessionManager: SessionManager, requestInterface: RequestInterface): ListViewModelFactory {
        return ListViewModelFactory(sessionManager, requestInterface)
    }

}