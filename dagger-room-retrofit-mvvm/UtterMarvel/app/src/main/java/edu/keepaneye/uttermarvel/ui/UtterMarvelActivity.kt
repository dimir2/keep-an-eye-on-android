package edu.keepaneye.uttermarvel.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import edu.keepaneye.uttermarvel.R
import edu.keepaneye.uttermarvel.app.App
import edu.keepaneye.uttermarvel.db.MarvelDatabase
import edu.keepaneye.uttermarvel.repository.MarvelRepository
import kotlinx.android.synthetic.main.activity_utter_marvel.*
import javax.inject.Inject

class UtterMarvelActivity : AppCompatActivity() {
    @Inject
    lateinit var vmFactory: MarvelViewModelProviderFactory
    lateinit var viewModel: MarvelViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_utter_marvel)

        (applicationContext as App).appComponent.inject(this)

//        val marvelRepository = MarvelRepository(MarvelDatabase(this))
//        val viewModelProviderFactory = MarvelViewModelProviderFactory(marvelRepository)
        viewModel = ViewModelProvider(this, vmFactory).get(MarvelViewModel::class.java)

        bottomNavigationView.setupWithNavController(marvelNavHostFragment.findNavController())

    }
}