package com.sample.testcomponents.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.sample.testcomponents.databinding.FragmentGridRecyclerBinding
import com.sample.testcomponents.ui.adapter.GridLayoutAdapter
import com.sample.testcomponents.ui.data.AppDataItem
import com.sample.testcomponents.util.RecyclerViewItemDecorator
import com.sample.testcomponents.util.SampleUtils

class GridLayoutFragment: Fragment() {

    private var binding: FragmentGridRecyclerBinding? = null

    private var gridAdapter: GridLayoutAdapter? = null

    private var appListArray: ArrayList<AppDataItem>? = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentGridRecyclerBinding.inflate(inflater, container, false)
        setUpRecyclerView()
        return binding!!.root
    }

    private fun setUpRecyclerView() {
        populateData()
        binding!!.gridRecycler.apply {
            layoutManager =
                GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            addItemDecoration(RecyclerViewItemDecorator(SampleUtils().dpToPx(0)))
            setHasFixedSize(true)
            adapter = gridAdapter
        }
    }

    private fun populateData() {
        val first = AppDataItem("Youtube", "Media", "Update")
        val second = AppDataItem("Games", "Entertainment", "Install")
        val third = AppDataItem("Music", "Player", "Install")
        appListArray!!.add(first)
        appListArray!!.add(second)
        appListArray!!.add(third)

        gridAdapter = GridLayoutAdapter(appListArray)
    }
}