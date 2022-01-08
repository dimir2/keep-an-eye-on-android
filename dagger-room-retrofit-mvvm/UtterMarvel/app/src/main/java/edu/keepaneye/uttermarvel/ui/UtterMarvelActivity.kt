package edu.keepaneye.uttermarvel.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import edu.keepaneye.uttermarvel.R
import kotlinx.android.synthetic.main.activity_utter_marvel.*

class UtterMarvelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_utter_marvel)

        bottomNavigationView.setupWithNavController(marvelNavHostFragment.findNavController())

    }
}