package edu.keepaneye.app5_1

interface Product {
    fun dispence():Int
}

class Crisps : Product {
    override fun dispence(): Int {
        return R.drawable.crisps
    }
}
class Drink : Product {
    override fun dispence(): Int {
        return R.drawable.drink
    }
}
class Fruit : Product {
    override fun dispence(): Int {
        return R.drawable.fruit
    }
}

class Facade {
    private val crisps:Product = Crisps()
    private val drink:Product = Drink()
    private val fruit:Product = Fruit()

    fun dispenceCrisps():Int {
        return crisps.dispence()
    }
    fun dispenceDrink():Int {
        return drink.dispence()
    }
    fun dispenceFruit():Int {
        return fruit.dispence()
    }
}