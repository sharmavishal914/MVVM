package com.vishal.kotlinmvvm.ui.forgot

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.emailValidator
import com.vishal.kotlinmvvm.R
import com.vishal.kotlinmvvm.databinding.ActivityForgotBinding
import com.vishal.kotlinmvvm.ui.base.BaseActivity
import com.vishal.kotlinmvvm.util.emptyStringIfNull
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class ForgotActivity : BaseActivity(), ForgotNavigator {

    @Inject
    lateinit var forgotViewModelFactory: ForgotViewModelFactory
    lateinit var viewModel: ForgotViewModel
    lateinit var activityForgotBinding: ActivityForgotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialise()
    }

    private fun initialise() {
        viewModel = ViewModelProviders.of(this, forgotViewModelFactory).get(ForgotViewModel::class.java)
        viewModel.forgotNavigator = this

        // Binding UI
        activityForgotBinding = DataBindingUtil.setContentView(this, R.layout.activity_forgot)
        activityForgotBinding.viewModel = viewModel
        activityForgotBinding.navigator = this
        activityForgotBinding.setLifecycleOwner(this)

        //ToolBar
        initialiseToolBar("Forget Password", true)
    }

    override fun onForgot() {
        if (viewModel.email.value.emptyStringIfNull().trim({ it <= ' ' }) == "") {
            showSnackBar(constraint_root, resources.getString(R.string.validation_email))
        } else if (!emailValidator(viewModel.email.value.emptyStringIfNull().trim({ it <= ' ' }))) {
            showSnackBar(constraint_root, resources.getString(R.string.validation_email_address))
        } else {
            if (isNetworkConnected()) {
                viewModel.isLoading.value = true
            } else {
                showSnackBar(constraint_root, "No Internet Connection")
            }
        }
    }

}

