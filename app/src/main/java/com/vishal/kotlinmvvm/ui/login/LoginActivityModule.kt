package com.vishal.kotlinmvvm.ui.login

import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface
import dagger.Module
import dagger.Provides

@Module
class LoginActivityModule {

    @Provides
    fun provideLoginViewModel(sessionManager: SessionManager, requestInterface: RequestInterface): LoginViewModel {
        return LoginViewModel(sessionManager, requestInterface)
    }
}
