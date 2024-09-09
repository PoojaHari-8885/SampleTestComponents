package com.sample.testcomponents.util

import android.content.res.Resources
import android.util.DisplayMetrics
import kotlin.math.roundToInt

class SampleUtils {

    fun dpToPx(dp: Int): Int {
        return (dp * (Resources.getSystem().displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
            .roundToInt()
            .toInt()
    }
}