package com.vishal.kotlinmvvm.ui.home.list

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.vishal.kotlinmvvm.R
import com.vishal.kotlinmvvm.data.model.Model
import com.vishal.kotlinmvvm.databinding.RowUserBinding

class ListAdapter(var arrayList: ArrayList<Model>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    var layoutInflater: LayoutInflater? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        var binding: RowUserBinding = DataBindingUtil.inflate(this!!.layoutInflater!!, R.layout.row_user, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = arrayList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.user = arrayList[position]
        holder.binding.executePendingBindings()

        holder.binding.restaurantImageView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    class ViewHolder(var binding: RowUserBinding) : RecyclerView.ViewHolder(binding.root)
}