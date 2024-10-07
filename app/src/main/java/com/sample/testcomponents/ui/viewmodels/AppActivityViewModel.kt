package com.sample.testcomponents.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.testcomponents.ui.data.SubscriptionDataItem

class AppActivityViewModel : ViewModel() {

    private var _notifyChange = MutableLiveData<SubscriptionDataItem>()
    val notifyChange = _notifyChange

    fun setSubscriptionData(subscriptionDataItem: SubscriptionDataItem) {
        _notifyChange.value = subscriptionDataItem
    }

}