package edu.keepaneye.uttermarvel.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import edu.keepaneye.uttermarvel.R
import edu.keepaneye.uttermarvel.ui.MarvelViewModel
import edu.keepaneye.uttermarvel.ui.UtterMarvelActivity
import kotlinx.android.synthetic.main.fragment_character_item.*

class MarvelCharacterItemFragment : Fragment(R.layout.fragment_character_item) {
    lateinit var viewModel: MarvelViewModel
    val args: MarvelCharacterItemFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as UtterMarvelActivity).viewModel
        val character = args.character
        view.apply {
            Glide
                .with(this)
                .load("${character.thumbnail.path}.${character.thumbnail.extension}")
                .into(ivItemImage)
            tvItemName.text = character.name
        }
        fab.setOnClickListener {
            viewModel.saveCharacter(character = character)
            Snackbar.make(view, "Character ${character.name} saved successfully", Snackbar.LENGTH_SHORT).show()
        }
    }
}