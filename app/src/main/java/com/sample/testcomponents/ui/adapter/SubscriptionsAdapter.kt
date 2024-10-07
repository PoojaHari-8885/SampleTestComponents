package com.sample.testcomponents.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sample.testcomponents.R
import com.sample.testcomponents.ui.data.SubscriptionDataItem
import com.sample.testcomponents.ui.interfaces.ItemClickListener


class SubscriptionsAdapter(private val subscriptionsList: ArrayList<SubscriptionDataItem>?, private val subscriptionButtonListener: ItemClickListener) :
    Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriptionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View =
            layoutInflater.inflate(R.layout.subscriptions_list_adapter, parent, false)
        val viewHolder = SubscriptionViewHolder(listItem)
        return viewHolder
    }

    override fun getItemCount(): Int {
        if (subscriptionsList!!.isEmpty()) {
            return 0
        } else {
            return subscriptionsList.size
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SubscriptionViewHolder).bind(subscriptionsList!![position])
    }

    inner class SubscriptionViewHolder(itemView: View) : ViewHolder(itemView) {

        private var subscriptionAppName: TextView =
            itemView.findViewById<View>(R.id.subscription_app_name) as TextView
        private var subscriptionAppDescription: TextView =
            itemView.findViewById<View>(R.id.subscription_app_description) as TextView
        private var subscribtionRateButton: Button =
            itemView.findViewById<View>(R.id.subscription_rate) as Button

        fun bind(appItem: SubscriptionDataItem) {
            subscriptionAppName.text = appItem.appName
            subscriptionAppDescription.text = appItem.appDescription
            subscribtionRateButton.text = appItem.appStatus

            subscribtionRateButton.setOnClickListener {
                subscriptionButtonListener.onSubscriptionButtonClick(appItem)
            }
        }
    }
}