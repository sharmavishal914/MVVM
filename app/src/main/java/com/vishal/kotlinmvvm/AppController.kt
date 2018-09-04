package com.vishal.kotlinmvvm

import android.app.Activity
import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import android.support.v4.app.Fragment
import com.vishal.kotlinmvvm.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasFragmentInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class AppController : MultiDexApplication(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>


    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentInjector
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector;
    }

    override fun onCreate() {
        DaggerAppComponent.builder().application(this).build().inject(this)
        super.onCreate()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}