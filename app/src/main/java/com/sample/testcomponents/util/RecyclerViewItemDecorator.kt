package com.sample.testcomponents.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewItemDecorator(private val spaceInPixels: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        outRect.left = spaceInPixels
        outRect.top = spaceInPixels
        outRect.right = spaceInPixels
        outRect.bottom = spaceInPixels
        super.getItemOffsets(outRect, view, parent, state)
    }
}
