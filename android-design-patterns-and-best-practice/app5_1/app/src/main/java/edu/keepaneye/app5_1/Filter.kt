package edu.keepaneye.app5_1

interface Filter {
    fun meetCriteria(ingredients:List<Ingredient>):List<Ingredient>
}

data class Ingredient(val name:String, val local:String, val vegetarian:Boolean)

class VegetarianFilter: Filter {
    override fun meetCriteria(ingredients: List<Ingredient>): List<Ingredient> {
        val vegetarian:MutableList<Ingredient> = arrayListOf()
        for (ingredient in ingredients) {
            if(ingredient.vegetarian) vegetarian.add(ingredient)
        }
        return vegetarian
    }
}

class LocalFilter: Filter {
    override fun meetCriteria(ingredients: List<Ingredient>): List<Ingredient> {
        val local:MutableList<Ingredient> = arrayListOf()
        for(ingredient in ingredients) {
            if(ingredient.local.equals("Locally produced")) local.add(ingredient)
        }
        return local
    }
}

class NonLocalFilter: Filter {
    override fun meetCriteria(ingredients: List<Ingredient>): List<Ingredient> {
        val nonLocal:MutableList<Ingredient> = arrayListOf()
        for(ingredient in ingredients) {
            if(!ingredient.local.equals("Locally produced")) nonLocal.add(ingredient)
        }
        return nonLocal
    }
}

class AddCriteria(val criteria:Filter, val otherCriteria: Filter): Filter {
    override fun meetCriteria(ingredients: List<Ingredient>): List<Ingredient> {
        val firstCriteria:List<Ingredient> = criteria.meetCriteria(ingredients)
        return otherCriteria.meetCriteria(firstCriteria)
    }
}

class OrCriteria(val criteria:Filter, val otherCriteria: Filter): Filter {
    override fun meetCriteria(ingredients: List<Ingredient>): List<Ingredient> {
        val firstCriteria:List<Ingredient> = criteria.meetCriteria(ingredients)
        val nextCriteria:List<Ingredient> = criteria.meetCriteria(ingredients)
        val joinedCriteria:MutableList<Ingredient> = mutableListOf()
        joinedCriteria.addAll(firstCriteria)
        return firstCriteria + nextCriteria
    }
}