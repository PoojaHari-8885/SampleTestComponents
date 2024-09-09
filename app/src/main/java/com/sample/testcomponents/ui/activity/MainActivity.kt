package com.sample.testcomponents.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sample.testcomponents.R
import com.sample.testcomponents.databinding.MainActivityBinding
import com.sample.testcomponents.ui.fragment.GridLayoutFragment

class MainActivity : AppCompatActivity() {

    private var binding: MainActivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        binding!!.title.text = applicationContext.resources.getString(R.string.app_title)
        setContentView(binding!!.root)
    }

    override fun onResume() {
        super.onResume()
        loadFragment()
    }

    private fun loadFragment() {
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container, GridLayoutFragment()).addToBackStack(null).commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}