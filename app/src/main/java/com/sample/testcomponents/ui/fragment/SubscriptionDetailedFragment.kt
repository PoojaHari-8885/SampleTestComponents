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
    private lateinit var categoryLayout: LinearLayout
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
    private lateinit var appsSizeIcon: ImageView

    private lateinit var providerText: TextView
    private lateinit var providerNameTextView: TextView
    private lateinit var sizeText: TextView
    private lateinit var sizeValueTextView: TextView
    private lateinit var languagesText: TextView
    private lateinit var languagesValueTextView: TextView
    private lateinit var categoryText: TextView
    private lateinit var categoryNameTextView: TextView
    private lateinit var compatibilityText: TextView
    private lateinit var compatibilityValueTextView: TextView
    private lateinit var copyrightText: TextView
    private lateinit var copyrightNameTextView: TextView

    private lateinit var appIcon: ImageView
    private lateinit var appName: TextView
    private lateinit var appShortDesc: TextView

    private lateinit var subscribeButton: Button
    private lateinit var subscribeCharge: TextView

    private lateinit var appShortDetail: TextView
    private lateinit var appLongDescription: TextView

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
        setAppDescriptionDetails()
        setAppDetails()
        setInformationDetails()
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
        downloadsTextView.text = resources.getString(R.string.downloads)
        downloadsIcon = downloadsLayout.findViewById(R.id.icon_view)

        appSizeTextView = appsSizeLayout.findViewById(R.id.main_text)
        appSizeMeasureTextView = appsSizeLayout.findViewById(R.id.sub_text)
        appsSizeIcon = appsSizeLayout.findViewById(R.id.icon_view)

        providerLayout = scrollLayout.findViewById(R.id.provider_info)
        sizeLayout = scrollLayout.findViewById(R.id.size_info)
        languagesLayout = scrollLayout.findViewById(R.id.language_info)
        categoryLayout = scrollLayout.findViewById(R.id.category_info)
        compatibilityLayout = scrollLayout.findViewById(R.id.compatibility_info)
        copyrightLayout = scrollLayout.findViewById(R.id.copyright_info)

        providerText = providerLayout.findViewById(R.id.info_main_text)
        providerText.text = resources.getString(R.string.provider)
        providerNameTextView = providerLayout.findViewById(R.id.info_sub_text)

        sizeText = sizeLayout.findViewById(R.id.info_main_text)
        sizeText.text = resources.getString(R.string.size)
        sizeValueTextView = sizeLayout.findViewById(R.id.info_sub_text)

        languagesText = languagesLayout.findViewById(R.id.info_main_text)
        languagesText.text = resources.getString(R.string.languages)
        languagesValueTextView = languagesLayout.findViewById(R.id.info_sub_text)

        categoryText = categoryLayout.findViewById(R.id.info_main_text)
        categoryText.text = resources.getString(R.string.category)
        categoryNameTextView = categoryLayout.findViewById(R.id.info_sub_text)

        compatibilityText = compatibilityLayout.findViewById(R.id.info_main_text)
        compatibilityText.text = resources.getString(R.string.compatibility)
        compatibilityValueTextView = compatibilityLayout.findViewById(R.id.info_sub_text)

        copyrightText = copyrightLayout.findViewById(R.id.info_main_text)
        copyrightText.text = resources.getString(R.string.copyright)
        copyrightNameTextView = copyrightLayout.findViewById(R.id.info_sub_text)

        appIcon = scrollLayout.findViewById(R.id.sub_detail_icon)
        appName = scrollLayout.findViewById(R.id.sub_detail_app_name)
        appShortDesc = scrollLayout.findViewById(R.id.sub_detail_app_description)

        subscribeButton = scrollLayout.findViewById(R.id.sub_detail_rate)
        subscribeCharge = scrollLayout.findViewById(R.id.sub_detail_charge)

        appShortDetail = scrollLayout.findViewById(R.id.sub_small_description)
        appLongDescription = scrollLayout.findViewById(R.id.text_detail_description)
    }

    private fun configureBtnClick() {
        backButton.setOnClickListener {
            if (requireActivity().supportFragmentManager.backStackEntryCount > 0) {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }

        subscribeButton.setOnClickListener {
            loadSubscriptionPaymentFragment()
        }
    }

    private fun loadSubscriptionPaymentFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SubscriptionPaymentFragment())
            .addToBackStack("SubscriptionPaymentFragment")
            .commitAllowingStateLoss()
    }

    private fun setAppDescriptionDetails() {
        appIcon.setImageResource(R.drawable.ic_launcher_foreground)
        appName.text = "DriveSmartPlus"
        appShortDesc.text = "Smart Car Manager"

        subscribeButton.text = "Subscribe Rs 499"
        subscribeCharge.text = "One time charge"

        appShortDetail.text = "Your all-in-one smart car manager for safe smarter driving"
        appLongDescription.text = "Unlock your full potential of your cras infotainment system"
    }

    private fun setAppDetails() {
        reviewTextView.text = "4.5"
        reviewCountTextView.text = "100 Reviews"
        reviewStarIcon.setImageResource(R.drawable.ic_launcher_foreground)

        downloadsCountTextView.text = "500K+"
        downloadsIcon.setImageResource(R.drawable.ic_launcher_foreground)

        appSizeTextView.text = "194"
        appSizeMeasureTextView.text = "MB"
        appsSizeIcon.setImageResource(R.drawable.ic_launcher_foreground)
    }

    private fun setInformationDetails() {
        providerNameTextView.text = "The Omani Group"
        sizeValueTextView.text = "194 MB"
        languagesValueTextView.text = "English"
        categoryNameTextView.text = "Producitivity"
        compatibilityValueTextView.text = "Yes"
        copyrightNameTextView.text = "Copyright 2023"
    }
}