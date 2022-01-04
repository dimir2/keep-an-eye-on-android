package edu.keepaneye.app7.builder

import android.view.ViewGroup
import edu.keepaneye.app7.R

interface LayoutView {
    fun layoutParams(): ViewGroup.LayoutParams
    fun textSize(): Int
    fun content(): Int
    fun shading(): Shading
    fun padding(): Array<Int>
}

interface Shading {
    fun shade(): Int
    fun background(): Int
}

class HeaderShading : Shading {
    override fun shade(): Int {
        return R.color.text_primary_dark
    }

    override fun background(): Int {
        return R.color.header_background
    }
}

class ContentShading : Shading {
    override fun shade(): Int {
        return R.color.text_secondary_dark
    }

    override fun background(): Int {
        return R.color.content_background
    }
}

abstract class Header : LayoutView {
    override fun shading(): Shading {
        return HeaderShading()
    }
}

abstract class Content : LayoutView {
    override fun shading(): Shading {
        return ContentShading()
    }
}

class Headline : Header() {
    override fun layoutParams(): ViewGroup.LayoutParams {
        return ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun textSize(): Int {
        return 24
    }

    override fun content(): Int {
        return R.string.headline
    }

    override fun padding(): Array<Int> {
        return arrayOf(24, 16, 16, 0)
    }

}

class SubHeadline : Header() {
    override fun layoutParams(): ViewGroup.LayoutParams {
        return ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun textSize(): Int {
        return 18
    }

    override fun content(): Int {
        return R.string.sub_head
    }

    override fun padding(): Array<Int> {
        return arrayOf(32, 0, 16, 8)
    }
}

class SimpleContent : Content() {
    override fun layoutParams(): ViewGroup.LayoutParams {
        return ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    override fun textSize(): Int {
        return 14
    }

    override fun content(): Int {
        return R.string.short_text
    }

    override fun padding(): Array<Int> {
        return arrayOf(16, 18, 16, 16)
    }
}

class DetailedContent : Content() {
    override fun layoutParams(): ViewGroup.LayoutParams {
        return ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    override fun textSize(): Int {
        return 12
    }

    override fun content(): Int {
        return R.string.long_text
    }

    override fun padding(): Array<Int> {
        return arrayOf(16, 18, 16, 16)
    }
}
