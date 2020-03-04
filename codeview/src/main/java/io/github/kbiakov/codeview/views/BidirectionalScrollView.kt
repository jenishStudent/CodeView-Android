package io.github.kbiakov.codeview.views

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.View.MeasureSpec.makeMeasureSpec
import android.widget.HorizontalScrollView
import io.github.kbiakov.codeview.dpToPx

/**
 * @class BidirectionalScrollView
 *
 * Combines vertical & horizontal scroll to implement bidirectional
 * scrolling behavior (like a map view, for example).
 *
 * @author Kirill Biakov
 */
class BidirectionalScrollView : HorizontalScrollView {

    private var currentX = 0
    private var currentY = 0
    private var isMoved = false

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun measureChild(child: View, parentWidthMeasureSpec: Int, parentHeightMeasureSpec: Int) {
        val zeroMeasureSpec = makeMeasureSpec(0)
        child.measure(zeroMeasureSpec, zeroMeasureSpec)
    }

    override fun measureChildWithMargins(
            child: View,
            parentWidthMeasureSpec: Int, widthUsed: Int,
            parentHeightMeasureSpec: Int, heightUsed: Int
    ) = with(child.layoutParams as MarginLayoutParams) {
        val widthMeasureSpec = makeMeasureSpec(leftMargin + rightMargin, MeasureSpec.UNSPECIFIED)
        val heightMeasureSpec = makeMeasureSpec(topMargin + bottomMargin, MeasureSpec.UNSPECIFIED)
        child.measure(widthMeasureSpec, heightMeasureSpec)
    }

    private fun makeMeasureSpec(size: Int) = makeMeasureSpec(size, MeasureSpec.UNSPECIFIED)
}
