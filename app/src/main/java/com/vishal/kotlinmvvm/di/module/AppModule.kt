package com.vishal.kotlinmvvm.di.module

import android.content.Context
import com.vishal.kotlinmvvm.AppController
import com.vishal.kotlinmvvm.data.local.SessionManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Administrator on 1/15/2018.
 */

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideApplication(app: AppController): Context = app


    @Provides
    @Singleton
    fun provideSessionManagerModule(context: Context): SessionManager {
        return SessionManager(context!!.getSharedPreferences("SharedPref", Context.MODE_PRIVATE))
    }
}