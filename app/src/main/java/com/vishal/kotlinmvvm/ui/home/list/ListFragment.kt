package com.vishal.kotlinmvvm.ui.home.list


import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vishal.kotlinmvvm.R
import com.vishal.kotlinmvvm.data.model.Model
import com.vishal.kotlinmvvm.databinding.FragmentListBinding
import com.vishal.kotlinmvvm.ui.base.BaseFragment
import javax.inject.Inject


class ListFragment : BaseFragment() {

    lateinit var binding: FragmentListBinding
    @Inject
    lateinit var listViewModelFactory: ListViewModelFactory
    lateinit var viewModel: ListViewModel
    lateinit var adapter: ListAdapter
    var arrayList = ArrayList<Model>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initilise(inflater, container)
        return binding.root
    }

    private fun initilise(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        viewModel = ViewModelProviders.of(this, listViewModelFactory).get(ListViewModel::class.java)
        binding.viewModel = viewModel

        // Recycler adapter
        addDummyData()
        adapter = ListAdapter(arrayList)
        binding.recyclerList.layoutManager = LinearLayoutManager(activity)
        binding.recyclerList.adapter = adapter
    }

    private fun addDummyData() {
        arrayList.add(Model("Vishal", ""))
        arrayList.add(Model("123", ""))
        arrayList.add(Model("123", ""))
        arrayList.add(Model("123", ""))
        arrayList.add(Model("123", ""))
        arrayList.add(Model("123", ""))
        arrayList.add(Model("123", ""))
        arrayList.add(Model("123", ""))
    }
}
