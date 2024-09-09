package com.sample.testcomponents.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sample.testcomponents.R
import com.sample.testcomponents.databinding.MainActivityBinding
import com.sample.testcomponents.ui.fragment.AppsFragment
import com.sample.testcomponents.ui.fragment.SubscriptionFragment

class MainActivity : AppCompatActivity() {

    private var binding: MainActivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        setUpTab()
    }

    override fun onResume() {
        super.onResume()
        binding!!.appsTab.tabItem.performClick()
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container, fragment).addToBackStack(null).commit()
    }

    private fun setUpTab() {
        binding?.apply {

            appsTab.tabTitle.text = "Apps"
            subscriptionsTab.tabTitle.text = "Feature Subscription"

            appsTab.tabItem.setOnClickListener {
                loadFragment(AppsFragment())
            }

            subscriptionsTab.tabItem.setOnClickListener {
                loadFragment(SubscriptionFragment())
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}