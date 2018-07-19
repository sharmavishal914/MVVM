package com.vishal.kotlinmvvm.ui.home

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import com.vishal.chat.ui.home.home.HomeFragment
import com.vishal.kotlinmvvm.R
import com.vishal.kotlinmvvm.data.model.Model
import com.vishal.kotlinmvvm.ui.login.BaseActivity
import com.vishal.kotlinmvvm.ui.login.LoginViewModel
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeNavigator {

    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory
    lateinit var mHomeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initialise()

        if (savedInstanceState == null) {
            homeFragement()
        }

        // Development Branch
        // Development Branch test
    }

    private fun initialise() {
        mHomeViewModel = ViewModelProviders.of(this, homeViewModelFactory).get(HomeViewModel::class.java!!)
        mHomeViewModel.mNavigator = this
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
//        showSnackBar(constraint_root, model.ip)
    }

}

