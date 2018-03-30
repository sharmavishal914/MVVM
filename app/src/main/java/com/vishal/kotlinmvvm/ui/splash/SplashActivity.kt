package com.vishal.kotlinmvvm.ui.splash

import android.os.Bundle
import com.vishal.kotlinmvvm.ui.login.BaseActivity
import android.content.Intent
import com.vishal.kotlinmvvm.ui.login.LoginActivity


class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nextScreen()
    }

    private fun nextScreen() {
        startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        finish()
    }
}
