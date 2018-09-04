package com.vishal.kotlinmvvm.ui.splash

import android.os.Bundle
import android.content.Intent
import android.os.Handler
import com.vishal.kotlinmvvm.ui.base.BaseActivity
import com.vishal.kotlinmvvm.ui.login.LoginActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nextScreen()
    }


    private fun nextScreen() {
        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()
        }, 2000)
    }
}
