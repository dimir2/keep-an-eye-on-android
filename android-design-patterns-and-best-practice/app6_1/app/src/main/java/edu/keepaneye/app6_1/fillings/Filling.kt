package edu.keepaneye.app6_1.fillings

import edu.keepaneye.app6_1.R

interface Filling {
    val name: String
    val image: Int
    val kcal: Int
    val veg: Boolean
    val price: Int
}

abstract class Cheese(
    override val name: String,
    override val image: Int,
    override val kcal: Int,
    override val veg: Boolean,
    override val price: Int
) : Filling

class Brie : Cheese("Brie", R.drawable.brie, 160, true, 105)
class Camembert : Cheese("Camembert", R.drawable.camembert, 155, true, 110)
class Cheddar : Cheese("Cheddar", R.drawable.cheddar, 130, true, 75)
class Dorblu : Cheese("Dorblu", R.drawable.dorblu, 140, true, 85)
class Edam : Cheese("Edam", R.drawable.edam, 120, true, 80)
class Emmental : Cheese("Emmental", R.drawable.emmental, 145, true, 95)
class Gouda : Cheese("Gouda", R.drawable.gouda, 115, true, 85)
class Manchego : Cheese("Manchego", R.drawable.manchego, 125, true, 90)
class Mozzarella : Cheese("Mozzarella", R.drawable.mozzarella, 105, true, 65)
class Roquefort : Cheese("Roquefort", R.drawable.roquefort, 155, true, 150)

fun buildCheeseList(): List<Cheese> {
    return arrayListOf(
        Brie(),
        Camembert(),
        Cheddar(),
        Dorblu(),
        Edam(),
        Emmental(),
        Gouda(),
        Manchego(),
        Mozzarella(),
        Roquefort()
    )
}
