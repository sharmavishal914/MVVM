package com.vishal.kotlinmvvm.ui.home.home


import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import javax.inject.Inject
import com.vishal.kotlinmvvm.R
import com.vishal.kotlinmvvm.databinding.FragmentHomeBinding
import com.vishal.kotlinmvvm.ui.base.BaseFragment


class HomeFragment : BaseFragment(), View.OnClickListener, HomeFragmentNavigator {

    @Inject
    lateinit var homeFragmentViewModelFactory: HomeFragmentViewModelFactory

    lateinit var viewModel: HomeFragmentViewModel
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initilise(inflater, container)

        return binding.root
    }

    private fun initilise(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProviders.of(this, homeFragmentViewModelFactory).get(HomeFragmentViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.mNavigator = this
    }

    override fun onClick(p: View?) {
        when (p!!.id) {
        }
    }
}
