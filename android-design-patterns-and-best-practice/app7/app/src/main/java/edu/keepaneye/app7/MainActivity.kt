package edu.keepaneye.app7

import android.os.Bundle
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.keepaneye.app7.builder.LayoutBuilder
import edu.keepaneye.app7.builder.LayoutView

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var layout: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val width: Int = ViewGroup.LayoutParams.MATCH_PARENT
        val height: Int = ViewGroup.LayoutParams.WRAP_CONTENT

        layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.layoutParams = ViewGroup.LayoutParams(width, height)

        setContentView(layout)

        val layoutBuilder = LayoutBuilder()
        val layoutViews: MutableList<LayoutView> = arrayListOf<LayoutView>()
        layoutViews.addAll(layoutBuilder.displayDetailed())
        layoutViews.addAll(layoutBuilder.displaySimple())

        for (layoutView in layoutViews) {
            val params = layoutView.layoutParams()
            textView = TextView(this)
            textView.layoutParams = params
            textView.setText(layoutView.content())
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, layoutView.textSize().toFloat())
            textView.setTextColor(layoutView.shading().shade())
            textView.setBackgroundResource(layoutView.shading().background())
            val pad = layoutView.padding()
            textView.setPadding(dp(pad[0]), dp(pad[1]), dp(pad[2]), dp(pad[3]))
            layout.addView(textView)
        }
    }

    private fun dp(px: Int): Int {
        return (px * resources.displayMetrics.density + 0.5f).toInt()
    }
}

