package edu.keepaneye.app5_1

import android.util.Log

interface SandwichInterface {
    fun makeSandwich(filling1: String, filling2: String)
}

abstract class AbstractSandwich(val sandwichInterface: SandwichInterface) {
    abstract fun make()
}

class Sandwich(
    private val filling1: String,
    private val filling2: String,
    sandwichInterface: SandwichInterface
) : AbstractSandwich(sandwichInterface) {

    override fun make() {
        sandwichInterface.makeSandwich(filling1, filling2)
    }
}

class Open : SandwichInterface {
    val TAG: String = "tag"
    override fun makeSandwich(filling1: String, filling2: String) {
        Log.d(TAG, "Open sandwich : $filling1 + $filling2")
    }
}

class Closed : SandwichInterface {
    val TAG: String = "tag"
    override fun makeSandwich(filling1: String, filling2: String) {
        Log.d(TAG, "Closed sandwich : $filling1 + $filling2")
    }
}