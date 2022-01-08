package edu.keepaneye.app7_1

abstract class Filling {
    abstract val description: String
    abstract val kcal: Int
}

class Lettuce : Filling() {
    override val description = "Lettuce"
    override val kcal = 1
}

abstract class FillingDecorator(private val filling: Filling) : Filling()

class DoublePortion(private val filling: Filling): FillingDecorator(filling) {
    override val description: String
        get() = "${filling.description} Double portion"
    override val kcal: Int
        get() = filling.kcal * 2
}
