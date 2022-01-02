package edu.keepaneye.app6_1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ItemDivider(context: Context, resId: Int) : RecyclerView.ItemDecoration() {
    private val divider: Drawable = ContextCompat.getDrawable(context, resId)!!

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left: Int = parent.paddingLeft
        val right: Int = parent.width - parent.paddingRight

        val count: Int = parent.childCount
        for (i in 0 until count) run {
            val child: View = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top: Int = child.bottom + params.bottomMargin
            val bottom: Int = top + divider.intrinsicHeight

            Rect(left, top, right, bottom).also { divider.bounds = it }
            divider.draw(canvas)
        }
    }
}