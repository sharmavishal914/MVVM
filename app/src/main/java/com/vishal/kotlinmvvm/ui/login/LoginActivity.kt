package com.vishal.kotlinmvvm.ui.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.vishal.kotlinmvvm.R
import com.vishal.kotlinmvvm.data.model.Model
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginNavigator {

    @Inject
    lateinit var mLoginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mLoginViewModel.mNavigator = this

        callApi()
    }

    private fun callApi() {
        showLoading()
        mLoginViewModel.callApi()
    }

    override fun openHomeScreen(model: Model) {
        hideLoading()
        showSnackBar(constraint_root, model.ip)
    }

}

