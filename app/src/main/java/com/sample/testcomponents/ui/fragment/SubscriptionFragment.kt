package com.sample.testcomponents.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.testcomponents.R
import com.sample.testcomponents.ui.adapter.SubscriptionsAdapter
import com.sample.testcomponents.ui.data.SubscriptionDataItem
import com.sample.testcomponents.ui.interfaces.ItemClickListener
import com.sample.testcomponents.ui.viewmodels.AppActivityViewModel

class SubscriptionFragment: Fragment(), ItemClickListener {

    private var subscriptionsAdapter: SubscriptionsAdapter? = null

    private var appListArray: ArrayList<SubscriptionDataItem>? = arrayListOf()

    private lateinit var subscriptionRecyclerView: RecyclerView

    val appActivityViewModel: AppActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_subscription_recycler, container, false)
        subscriptionRecyclerView = view.findViewById(R.id.subscription_recyclerview)
        setUpRecyclerView()
        observeViewModel()
        return view
    }

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
        val first = SubscriptionDataItem("Youtube", "Media", "Update", false)
        val second = SubscriptionDataItem("Games", "Entertainment", "Install", false)
        val third = SubscriptionDataItem("Music", "Player", "Install", false)
        appListArray!!.clear()
        appListArray!!.add(first)
        appListArray!!.add(second)
        appListArray!!.add(third)

        //Setting adapter
        subscriptionsAdapter = SubscriptionsAdapter(appListArray, this)
    }

    override fun onSubscriptionButtonClick(subscriptionDataItem : SubscriptionDataItem) {
        loadSubscriptionDetailFragment(subscriptionDataItem)
    }

    private fun loadSubscriptionDetailFragment(subscriptionDataItem : SubscriptionDataItem) {
        val fragment = SubscriptionDetailedFragment()
        fragment.arguments = Bundle().apply {
            putParcelable("subscriptionDataItem_Key", subscriptionDataItem)
        }
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack("SubscriptionDetailedFragment")
            .commitAllowingStateLoss()
    }

    private fun observeViewModel() {
        appActivityViewModel.notifyChange.observe(viewLifecycleOwner) {
            Log.d("POOJA123" , "observeViewModel : $it")
            subscriptionsAdapter?.notifyDataSetChanged()
        }
    }
}