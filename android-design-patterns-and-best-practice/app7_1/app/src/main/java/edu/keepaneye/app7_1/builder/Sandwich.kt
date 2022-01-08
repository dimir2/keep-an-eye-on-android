package edu.keepaneye.app7_1.builder

class Sandwich {
    private val ingredients : MutableList<Ingredient> = mutableListOf()

    public fun addIngredient(i: Ingredient) {
        ingredients.add(i)
    }

    public fun getKcal(): Int {
        var kcal: Int = 0
        for(ingredient in ingredients) {
            kcal += ingredient.kcal()
        }
        return kcal
    }

    public fun getSandwich() : String {
        val sb: StringBuilder  =  StringBuilder()
        for(ingredient in ingredients) {
            sb.append(ingredient.description()).append("\n")
        }
        return sb.toString()
    }
}

class SandwichBuilder {
    fun build(sandwich: Sandwich, ingredient: Ingredient): Sandwich {
        sandwich.addIngredient(ingredient)
        return sandwich
    }
}