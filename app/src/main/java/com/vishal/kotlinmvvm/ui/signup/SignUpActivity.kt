package com.vishal.kotlinmvvm.ui.signup

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.emailValidator
import com.vishal.kotlinmvvm.R
import com.vishal.kotlinmvvm.databinding.ActivitySignUpBinding
import com.vishal.kotlinmvvm.ui.base.BaseActivity
import com.vishal.kotlinmvvm.util.emptyStringIfNull
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class SignUpActivity : BaseActivity(), SignupNavigator {

    @Inject
    lateinit var signupViewModelFactory: SignupViewModelFactory
    lateinit var viewModel: SignupViewModel
    lateinit var activitySignUpBinding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialise()
    }

    private fun initialise() {
        viewModel = ViewModelProviders.of(this, signupViewModelFactory).get(SignupViewModel::class.java)
        viewModel.signupNavigator = this

        // Binding UI
        activitySignUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        activitySignUpBinding.viewModel = viewModel
        activitySignUpBinding.navigator = this
        activitySignUpBinding.setLifecycleOwner(this)

        //ToolBar
        initialiseToolBar("Sign Up", true)
    }

    override fun signup() {
        if (viewModel.first_name.value.emptyStringIfNull().trim({ it <= ' ' }) == "") {
            showSnackBar(constraint_root, resources.getString(R.string.validation_first_name))
        } else if (viewModel.last_name.value.emptyStringIfNull().trim({ it <= ' ' }) == "") {
            showSnackBar(constraint_root, resources.getString(R.string.validation_last_name))
        } else if (viewModel.email.value.emptyStringIfNull().trim({ it <= ' ' }) == "") {
            showSnackBar(constraint_root, resources.getString(R.string.validation_email))
        } else if (!emailValidator(viewModel.email.value.emptyStringIfNull().trim({ it <= ' ' }))) {
            showSnackBar(constraint_root, resources.getString(R.string.validation_email_address))
        } else if (viewModel.password.value.emptyStringIfNull().trim({ it <= ' ' }) == "") {
            showSnackBar(constraint_root, resources.getString(R.string.validation_password))
        } else if (viewModel.password.value.emptyStringIfNull().trim({ it <= ' ' }).length < 6) {
            showSnackBar(constraint_root, resources.getString(R.string.validation_password_length))
        } else if (viewModel.confirm_password.value.emptyStringIfNull().trim({ it <= ' ' }) == "") {
            showSnackBar(constraint_root, resources.getString(R.string.validation_password_confirm))
        } else if (viewModel.confirm_password.value.emptyStringIfNull() != viewModel.password.value) {
            showSnackBar(constraint_root, resources.getString(R.string.validation_password_match))
        } else {
            if (isNetworkConnected()) {
                viewModel.isLoading.value = true
            } else {
                showSnackBar(constraint_root, "No Internet Connection")
            }
        }
    }
}

