package com.sample.testcomponents.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.sample.testcomponents.R

class SubscriptionPaymentFragment: Fragment() {

    private lateinit var backButton: ImageView

    private lateinit var cardInfoLayout: LinearLayout
    private lateinit var upiInfoLayout: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.layout_sub_payment_screen, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureViews(view)
        configureBtnClick()
    }

    private fun configureViews(view: View) {
        backButton = view.findViewById(R.id.payment_back_button)
        cardInfoLayout = view.findViewById(R.id.payment_screen_card_info)
        upiInfoLayout = view.findViewById(R.id.payment_screen_upi_info)
    }

    private fun configureBtnClick() {
        backButton.setOnClickListener {
            if (requireActivity().supportFragmentManager.backStackEntryCount > 0) {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }

        cardInfoLayout.setOnClickListener {
            showPaymentStatusDialog()
        }
    }

    private fun showPaymentStatusDialog() {
        val paymentStatusDialog = PaymentStatusDialog()
        paymentStatusDialog.show(requireActivity().supportFragmentManager, "PaymentStatusDialog")
    }
}