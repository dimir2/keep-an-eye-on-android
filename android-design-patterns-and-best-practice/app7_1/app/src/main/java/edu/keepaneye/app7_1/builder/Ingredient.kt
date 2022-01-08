package edu.keepaneye.app7_1.builder

interface Ingredient {
    fun description(): String
    fun kcal(): Int
}

abstract class Bread : Ingredient

abstract class Filling : Ingredient

class Bagel : Bread() {
    override fun description(): String = "Bagel"
    override fun kcal(): Int = 250
}

class Bun : Bread() {
    override fun description(): String = "Bun"
    override fun kcal(): Int = 150
}

class Egg : Filling() {
    override fun description(): String = "Egg"
    override fun kcal(): Int = 100
}

class Cress : Filling() {
    override fun description(): String = "Cress"
    override fun kcal(): Int = 30
}

class Salt: Ingredient {
    override fun description(): String = "Salt"
    override fun kcal(): Int = 0
}