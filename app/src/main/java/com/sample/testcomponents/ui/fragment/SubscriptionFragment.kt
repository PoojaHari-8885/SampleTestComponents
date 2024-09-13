package com.sample.testcomponents.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.testcomponents.R
import com.sample.testcomponents.databinding.FragmentSubscriptionRecyclerBinding
import com.sample.testcomponents.ui.adapter.SubscriptionsAdapter
import com.sample.testcomponents.ui.data.AppDataItem
import com.sample.testcomponents.ui.interfaces.ItemClickListener

class SubscriptionFragment: Fragment(), ItemClickListener {

    private var subscriptionsAdapter: SubscriptionsAdapter? = null

    private var appListArray: ArrayList<AppDataItem>? = arrayListOf()

    private lateinit var subscriptionRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_subscription_recycler, container, false)
        subscriptionRecyclerView = view.findViewById(R.id.subscription_recyclerview)
        setUpRecyclerView()
        return view
    }

    @SuppressLint("ResourceAsColor")
    private fun setUpRecyclerView() {
        populateData()
        subscriptionRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            subscriptionRecyclerView.adapter = subscriptionsAdapter
        }
    }

    private fun populateData() {
        val first = AppDataItem("Youtube", "Media", "Update")
        val second = AppDataItem("Games", "Entertainment", "Install")
        val third = AppDataItem("Music", "Player", "Install")
        appListArray!!.add(first)
        appListArray!!.add(second)
        appListArray!!.add(third)

        //Setting adapter
        subscriptionsAdapter = SubscriptionsAdapter(appListArray, this)
    }

    override fun onSubscriptionButtonClick() {
        Log.d("POOJA","onSubscriptionButtonClick")
        loadSubscriptionFragment()
    }

    private fun loadSubscriptionFragment() {
        subscriptionRecyclerView.visibility = View.GONE
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.subscription_detailed_container, SubscriptionDetailedFragment())
            .commit()
    }
}