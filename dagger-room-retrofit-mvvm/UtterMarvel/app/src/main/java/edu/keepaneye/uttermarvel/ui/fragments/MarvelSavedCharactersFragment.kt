package edu.keepaneye.uttermarvel.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import edu.keepaneye.uttermarvel.R
import edu.keepaneye.uttermarvel.adapter.CharactersAtapter
import edu.keepaneye.uttermarvel.ui.MarvelViewModel
import edu.keepaneye.uttermarvel.ui.UtterMarvelActivity
import kotlinx.android.synthetic.main.fragment_saved_characters.*

class MarvelSavedCharactersFragment : Fragment(R.layout.fragment_saved_characters) {

    lateinit var viewModel: MarvelViewModel
    lateinit var charactersAdapter: CharactersAtapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as UtterMarvelActivity).viewModel

        setupRecyclerView()

        charactersAdapter.setOnItemClickListener { character ->
            val bundle = Bundle().apply {
                putSerializable("character", character)
            }
            findNavController().navigate(
                R.id.action_marvelSavedCharactersFragment_to_marvelCharacterItemFragment,
                bundle
            )
        }
    }

    private fun setupRecyclerView() {
        charactersAdapter = CharactersAtapter()
        rvSavedCharacters.apply {
            adapter = charactersAdapter
            layoutManager = GridLayoutManager(activity, 3)
        }
    }
}