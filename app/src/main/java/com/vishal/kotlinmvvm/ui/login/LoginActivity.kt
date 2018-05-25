package com.vishal.kotlinmvvm.ui.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.vishal.kotlinmvvm.R
import com.vishal.kotlinmvvm.data.model.Model
import com.vishal.kotlinmvvm.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginNavigator, View.OnClickListener {


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

    override fun onClick(p: View?) {
        when (p!!.id) {
            R.id.button_login -> {
                startActivity(Intent(applicationContext, HomeActivity::class.java))
            }
        }
    }
}

