package com.sample.testcomponents.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sample.testcomponents.databinding.AppsListAdapterBinding
import com.sample.testcomponents.ui.data.AppDataItem

class AppsAdapter(val appList: ArrayList<AppDataItem>?): Adapter<ViewHolder>() {

    var binding: AppsListAdapterBinding? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = AppsListAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GridLayoutViewHolder()
    }

    override fun getItemCount(): Int {
        return appList!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as GridLayoutViewHolder).bind(appList!![position])
    }

    inner class GridLayoutViewHolder: ViewHolder(binding!!.root) {

        fun bind(appItem: AppDataItem) {
            binding?.apply {
                appName.text = appItem.appName
                appDescription.text = appItem.appDescription
                appStatusButton.text = appItem.appStatus
            }
        }
    }
}