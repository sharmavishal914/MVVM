package com.vishal.kotlinmvvm.testing

import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface
import dagger.Module
import dagger.Provides

@Module
class TestActivityModule {

    @Provides
    fun provideTestViewModelFactory(sessionManager: SessionManager, requestInterface: RequestInterface): TestViewModelFactory {
        return TestViewModelFactory(sessionManager, requestInterface)
    }
}
