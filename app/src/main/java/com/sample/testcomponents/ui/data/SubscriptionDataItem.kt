package com.sample.testcomponents.ui.data

import android.os.Parcel
import android.os.Parcelable

data class SubscriptionDataItem(
    var appName: String?,
    var appDescription: String?,
    var appStatus: String?,
    var isSubscribed: Boolean
) : Parcelable {

    constructor(parcel: Parcel) : this (
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readBoolean())

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        p0.writeString(appName)
        p0.writeString(appDescription)
        p0.writeString(appStatus)
        p0.writeBoolean(isSubscribed)
    }

    companion object CREATOR : Parcelable.Creator<SubscriptionDataItem> {
        override fun createFromParcel(parcel: Parcel): SubscriptionDataItem {
            return SubscriptionDataItem(parcel)
        }

        override fun newArray(size: Int): Array<SubscriptionDataItem?> {
            return arrayOfNulls(size)
        }
    }
}