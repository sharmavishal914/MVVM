package com.vishal.kotlinmvvm.di.component

import com.vishal.kotlinmvvm.AppController
import com.vishal.kotlinmvvm.di.builder.ActivityBuilder
import com.vishal.kotlinmvvm.di.module.AppModule
import com.vishal.kotlinmvvm.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Administrator on 1/15/2018.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, AndroidInjectionModule::class,
        NetworkModule::class, ActivityBuilder::class))
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: AppController): Builder

        fun build(): AppComponent
    }

    fun inject(app: AppController)
}