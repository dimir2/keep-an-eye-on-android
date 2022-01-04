package edu.keepaneye.app7_1

abstract class Bread {
    abstract val description: String
    abstract val kcal: Int
}

class Bagel : Bread() {
    override val description: String = "Bagel"
    override val kcal: Int = 250
}

class Bun : Bread() {
    override val description: String = "Bun"
    override val kcal: Int = 150
}

abstract class BreadDecorator(private val bread: Bread) : Bread()

class Butter(private val bread: Bread) : BreadDecorator(bread) {
    override val description: String
        get() = "${bread.description} Butter"
    override val kcal: Int
        get() = bread.kcal + 50
}

class LowFatSpread(private val bread: Bread) : BreadDecorator(bread) {
    override val description: String
        get() = "${bread.description} Low fat spread"
    override val kcal: Int
        get() = bread.kcal + 25
}

class Toasted(private val bread: Bread) : BreadDecorator(bread) {
    override val description: String
        get() = "${bread.description} Toasted"
    override val kcal: Int
        get() = bread.kcal + 0
}

class Open(private val bread: Bread) : BreadDecorator(bread) {
    override val description: String
        get() = "${bread.description} Open"
    override val kcal: Int
        get() = bread.kcal / 2
}
