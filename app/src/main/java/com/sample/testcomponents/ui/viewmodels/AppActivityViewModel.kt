package com.sample.testcomponents.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import com.sample.testcomponents.ui.data.SubscriptionDataItem
import kotlinx.coroutines.flow.combine

class AppActivityViewModel : ViewModel() {

    private var _notifyChange = MutableLiveData<SubscriptionDataItem>()
    val notifyChange = _notifyChange

    private var _notifyPosChange = MutableLiveData<Int>()
    val notifyPosChange = _notifyPosChange

    fun setSubscriptionData(subscriptionDataItem: SubscriptionDataItem) {
        _notifyChange.value = subscriptionDataItem
    }

    fun setSubscriptionPosition(pos: Int) {
        _notifyPosChange.value = pos
    }
}