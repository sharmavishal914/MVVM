package com.vishal.chat.ui.home.home


import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vishal.kotlinmvvm.R
import com.vishal.kotlinmvvm.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject
import android.arch.lifecycle.ViewModelProviders


class HomeFragment : BaseFragment(), View.OnClickListener, HomeFragmentNavigator {

    @Inject
    lateinit var homeFragmentViewModel: HomeFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        homeFragmentViewModel.mNavigator = this
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callingViewModelFunction()
        liveData()
        textView.setText(homeFragmentViewModel.name)
    }

    override fun onResume() {
        if (isNetworkConnected()) {
            showToast("Internet connected")
        }

        super.onResume()
    }

    override fun onClick(p: View?) {
        when (p!!.id) {
            R.id.button_click -> {
                val anotherName = "John Doe"
//                homeFragmentViewModel.getCurrentName().setValue(anotherName)
                homeFragmentViewModel.name = anotherName
                textView.setText(homeFragmentViewModel.name)
            }
        }
    }

    private fun liveData() {
//        val nameObserver = object : Observer<String> {
//            override fun onChanged(t: String?) {
////                textView.setText(t)
//            }
//        }
//        homeFragmentViewModel.getCurrentName().observe(this, nameObserver)
        button_click.setOnClickListener(this)
    }

    private fun callingViewModelFunction() {
        homeFragmentViewModel.test()
    }

}
