package com.vishal.kotlinmvvm.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import com.vishal.chat.ui.home.home.HomeFragment
import com.vishal.kotlinmvvm.R
import com.vishal.kotlinmvvm.data.model.Model
import com.vishal.kotlinmvvm.ui.login.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeNavigator {

    @Inject
    lateinit var mHomeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mHomeViewModel.mNavigator = this

        callApi()
        homeFragement()
    }

    private fun homeFragement() {
        val homeFragment: Fragment = HomeFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frame_container, homeFragment).commit()
    }

    private fun callApi() {
        showLoading()
        mHomeViewModel.callApi()
    }

    override fun openHomeScreen(model: Model) {
        hideLoading()
        showSnackBar(constraint_root, model.ip)
    }

}

