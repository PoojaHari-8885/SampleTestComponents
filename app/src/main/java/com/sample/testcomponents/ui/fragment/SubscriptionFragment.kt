package com.sample.testcomponents.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.testcomponents.databinding.FragmentSubscriptionRecyclerBinding
import com.sample.testcomponents.ui.adapter.SubscriptionsAdapter
import com.sample.testcomponents.ui.data.AppDataItem

class SubscriptionFragment: Fragment() {

    private var binding: FragmentSubscriptionRecyclerBinding? = null

    private var subscriptionsAdapter: SubscriptionsAdapter? = null

    private var appListArray: ArrayList<AppDataItem>? = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentSubscriptionRecyclerBinding.inflate(inflater, container, false)
        setUpRecyclerView()
        return binding!!.root
    }

    private fun setUpRecyclerView() {
        populateData()
        binding!!.subscriptionRecyclerview.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = subscriptionsAdapter
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
        subscriptionsAdapter = SubscriptionsAdapter(appListArray)
    }
}