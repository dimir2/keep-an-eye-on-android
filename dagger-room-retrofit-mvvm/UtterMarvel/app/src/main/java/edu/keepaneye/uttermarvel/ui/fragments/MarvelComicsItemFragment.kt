package edu.keepaneye.uttermarvel.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import edu.keepaneye.uttermarvel.R
import edu.keepaneye.uttermarvel.ui.MarvelViewModel
import edu.keepaneye.uttermarvel.ui.UtterMarvelActivity

class MarvelComicsItemFragment:Fragment(R.layout.fragment_comics_item){
    lateinit var viewModel: MarvelViewModel
    val args : MarvelComicsItemFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as UtterMarvelActivity).viewModel
        val comicsItem = args.comics


    }
}