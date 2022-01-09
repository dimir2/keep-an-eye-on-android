package edu.keepaneye.uttermarvel.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import edu.keepaneye.uttermarvel.R
import edu.keepaneye.uttermarvel.ui.MarvelViewModel
import edu.keepaneye.uttermarvel.ui.UtterMarvelActivity
import kotlinx.android.synthetic.main.fragment_character_item.*

class MarvelCharacterItemFragment:Fragment(R.layout.fragment_character_item){
    lateinit var viewModel: MarvelViewModel
    val args : MarvelCharacterItemFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as UtterMarvelActivity).viewModel
        val comics = args

    }
}