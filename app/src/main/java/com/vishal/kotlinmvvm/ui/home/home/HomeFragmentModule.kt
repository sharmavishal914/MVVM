package com.vishal.chat.ui.home.home

import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule {

    @Provides
    fun provideHomeViewModel(sessionManager: SessionManager, requestInterface: RequestInterface): HomeFragmentViewModel {
        return HomeFragmentViewModel(sessionManager, requestInterface)
    }
}
