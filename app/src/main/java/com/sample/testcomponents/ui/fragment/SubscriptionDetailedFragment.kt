package com.sample.testcomponents.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.sample.testcomponents.R

class SubscriptionDetailedFragment: Fragment() {

    private lateinit var scrollLayout: RelativeLayout

    private lateinit var backButton: Button

    private lateinit var reviewLayout: RelativeLayout
    private lateinit var downloadsLayout: RelativeLayout
    private lateinit var appsSizeLayout: RelativeLayout

    private lateinit var providerLayout: LinearLayout
    private lateinit var sizeLayout: LinearLayout
    private lateinit var languagesLayout: LinearLayout
    private lateinit var companyLayout: LinearLayout
    private lateinit var compatibilityLayout: LinearLayout
    private lateinit var copyrightLayout: LinearLayout

    private lateinit var reviewTextView: TextView
    private lateinit var reviewCountTextView: TextView
    private lateinit var reviewStarIcon: ImageView

    private lateinit var downloadsCountTextView: TextView
    private lateinit var downloadsTextView: TextView
    private lateinit var downloadsIcon: ImageView

    private lateinit var appSizeTextView: TextView
    private lateinit var appSizeMeasureTextView: TextView
    private lateinit var appsIcon: ImageView

    private lateinit var providerText: TextView
    private lateinit var providerNameTextView: TextView
    private lateinit var sizeText: TextView
    private lateinit var sizeValueTextView: TextView
    private lateinit var languagesText: TextView
    private lateinit var languagesValueTextView: TextView
    private lateinit var companyText: TextView
    private lateinit var companyNameTextView: TextView
    private lateinit var compatibilityText: TextView
    private lateinit var compatibilityValueTextView: TextView
    private lateinit var copyrightText: TextView
    private lateinit var copyrightNameTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.subscription_scroll_view_container, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureViews(view)
        configureBtnClick()
    }

    private fun configureViews(view: View) {
        scrollLayout = view.findViewById(R.id.scroll_view_child_layout)

        backButton = scrollLayout.findViewById(R.id.subscription_back_button)

        reviewLayout = scrollLayout.findViewById(R.id.layout_review)
        downloadsLayout = scrollLayout.findViewById(R.id.layout_downloads)
        appsSizeLayout = scrollLayout.findViewById(R.id.layout_app_size)

        reviewTextView = reviewLayout.findViewById(R.id.main_text)
        reviewCountTextView = reviewLayout.findViewById(R.id.sub_text)
        reviewStarIcon = reviewLayout.findViewById(R.id.icon_view)

        downloadsCountTextView = downloadsLayout.findViewById(R.id.main_text)
        downloadsTextView = downloadsLayout.findViewById(R.id.sub_text)
        downloadsIcon = downloadsLayout.findViewById(R.id.icon_view)

        appSizeTextView = appsSizeLayout.findViewById(R.id.main_text)
        appSizeMeasureTextView = appsSizeLayout.findViewById(R.id.sub_text)
        appsIcon = appsSizeLayout.findViewById(R.id.icon_view)

        providerLayout = scrollLayout.findViewById(R.id.provider_info)
        sizeLayout = scrollLayout.findViewById(R.id.size_info)
        languagesLayout = scrollLayout.findViewById(R.id.language_info)
        companyLayout = scrollLayout.findViewById(R.id.category_info)
        compatibilityLayout = scrollLayout.findViewById(R.id.compatibility_info)
        copyrightLayout = scrollLayout.findViewById(R.id.copyright_info)

        providerText = providerLayout.findViewById(R.id.info_main_text)
        providerNameTextView = providerLayout.findViewById(R.id.info_sub_text)
        sizeText = sizeLayout.findViewById(R.id.info_main_text)
        sizeValueTextView = sizeLayout.findViewById(R.id.info_sub_text)
        languagesText = languagesLayout.findViewById(R.id.info_main_text)
        languagesValueTextView = languagesLayout.findViewById(R.id.info_sub_text)
        companyText = companyLayout.findViewById(R.id.info_main_text)
        companyNameTextView = companyLayout.findViewById(R.id.info_sub_text)
        compatibilityText = compatibilityLayout.findViewById(R.id.info_main_text)
        compatibilityValueTextView = compatibilityLayout.findViewById(R.id.info_sub_text)
        copyrightText = copyrightLayout.findViewById(R.id.info_main_text)
        copyrightNameTextView = copyrightLayout.findViewById(R.id.info_sub_text)
    }

    private fun configureBtnClick() {
        backButton.setOnClickListener {
            if (requireActivity().supportFragmentManager.backStackEntryCount > 0) {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }

        //Example for getting view
    }
}