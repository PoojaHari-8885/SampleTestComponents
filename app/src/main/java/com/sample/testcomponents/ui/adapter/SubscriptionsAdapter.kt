package com.sample.testcomponents.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sample.testcomponents.databinding.SubscriptionsListAdapterBinding
import com.sample.testcomponents.ui.data.AppDataItem

class SubscriptionsAdapter(val appList: ArrayList<AppDataItem>?): Adapter<ViewHolder>() {

    var binding: SubscriptionsListAdapterBinding? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = SubscriptionsListAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
                subscriptionAppName.text = appItem.appName
                subscriptionAppDescription.text = appItem.appDescription
                subscriptionRate.text = appItem.appStatus
            }
        }
    }
}