package com.vishal.kotlinmvvm.ui.home

import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {

    @Provides
    fun provideLoginViewModel(sessionManager: SessionManager, requestInterface: RequestInterface): HomeViewModel {
        return HomeViewModel(sessionManager, requestInterface)
    }
}
