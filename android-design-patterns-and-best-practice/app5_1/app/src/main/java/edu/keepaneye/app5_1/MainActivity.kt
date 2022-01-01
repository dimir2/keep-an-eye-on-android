package edu.keepaneye.app5_1

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text)
        val location: OldLocation = CustomerLocation("Town Hill", 3, "Office Space", 14)

        val newLocation: NewLocation = LocationAdapter(location)
        textView.text =
            newLocation.building + ", floor " + newLocation.floor + ", desk " + newLocation.desk

        var sandwich: AbstractSandwich = Sandwich("Cheese", "Tomato", Open())
        sandwich.make()

        sandwich = Sandwich("Ham", "Eggs", Closed())
        sandwich.make()

        val image = findViewById<ImageView>(R.id.image)

        val facade: Facade = Facade()

        image.setImageResource(facade.dispenceCrisps())


        val ingredients: MutableList<Ingredient> = arrayListOf(
            Ingredient("Cheddar", "Locally produced", true),
            Ingredient("Ham", "Cheshire", false),
            Ingredient("Tomato", "Kent", true),
            Ingredient("Turkey", "Locally produced", false)
        )

        val local: Filter = LocalFilter()
        val nonLocal: Filter = NonLocalFilter()
        val vegetarian: Filter = VegetarianFilter()
        val localAndVegetarian: Filter = AddCriteria(local, vegetarian)
        val localOrVegetarian: Filter = OrCriteria(local, vegetarian)

        val textFilter: TextView = findViewById <TextView>(R.id.filter)

        printIngredients(textFilter, local.meetCriteria(ingredients), "LOCAL")
        printIngredients(textFilter, nonLocal.meetCriteria(ingredients), "NON LOCAL")
        printIngredients(textFilter, vegetarian.meetCriteria(ingredients), "VEGETARIAN")
        printIngredients(textFilter, localAndVegetarian.meetCriteria(ingredients), "LOCAL VEGETARIAN")
        printIngredients(textFilter, localOrVegetarian.meetCriteria(ingredients), "ENVIRONMENTALLY FRIENDLY")
        val textFilter2: TextView = findViewById <TextView>(R.id.filter)
    }

    fun printIngredients( textView:TextView,  ingredients:List<Ingredient>,  header:String) {
        textView.append("\n$header:\n")
        Log.d("tag", "$header:")
        for (ingredient in ingredients) {
            textView.append("${ingredient.name} ${ingredient.local}\n")
            Log.d("tag", "${ingredient.name} ${ingredient.local}")
        }
    }
}