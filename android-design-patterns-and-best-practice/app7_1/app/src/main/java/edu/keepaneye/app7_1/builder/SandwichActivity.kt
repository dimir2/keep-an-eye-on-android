package edu.keepaneye.app7_1.builder

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.keepaneye.app7_1.R

class SandwichActivity : AppCompatActivity() {
    private lateinit var bagel: RadioButton
    private lateinit var egg: CheckBox
    private lateinit var cress: CheckBox
    private lateinit var salt: Switch
    private lateinit var order: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sandwich_layout)
        bagel = findViewById(R.id.radio_bagel)
        egg = findViewById(R.id.check_egg)
        cress = findViewById(R.id.check_cress)
        salt = findViewById(R.id.switch_salt)
        order = findViewById(R.id.text_order)
    }

    fun onActionOkClicked(view: View) {
        val builder = SandwichBuilder()
        var sandwich = Sandwich()

        if (bagel.isChecked) {
            sandwich = builder.build(sandwich, Bagel())
        } else {
            sandwich = builder.build(sandwich, Bun())
        }
        if (egg.isChecked) {
            sandwich = builder.build(sandwich, Egg())
        }
        if (cress.isChecked) {
            sandwich = builder.build(sandwich, Cress())
        }

        if (salt.isChecked) {
            sandwich = builder.build(sandwich, Salt())
        }
        order.setText("${sandwich.getSandwich()}\n${sandwich.getKcal()}")
    }
}