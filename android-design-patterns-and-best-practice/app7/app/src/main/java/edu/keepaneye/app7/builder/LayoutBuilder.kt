package edu.keepaneye.app7.builder

class LayoutBuilder {
    fun displayDetailed(): List<LayoutView> {
        return arrayListOf(Headline(), SubHeadline(), DetailedContent())
    }
    fun displaySimple() : List<LayoutView> {
        return arrayListOf(Headline(), SimpleContent())
    }
}