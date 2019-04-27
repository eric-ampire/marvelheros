package org.pbreakers.mobile.marvelheros.views

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import java.util.jar.Attributes

class SquareFrameLayout @JvmOverloads constructor(
    ctx: Context,
    attributSet: AttributeSet? = null,
    defaultStyle: Int) : FrameLayout(ctx, attributSet, defaultStyle) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}