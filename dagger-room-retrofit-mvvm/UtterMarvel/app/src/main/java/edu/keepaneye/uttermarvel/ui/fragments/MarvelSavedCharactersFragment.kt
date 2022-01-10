package edu.keepaneye.uttermarvel.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import edu.keepaneye.uttermarvel.R
import edu.keepaneye.uttermarvel.adapter.CharactersAtapter
import edu.keepaneye.uttermarvel.ui.MarvelViewModel
import edu.keepaneye.uttermarvel.ui.UtterMarvelActivity
import kotlinx.android.synthetic.main.fragment_saved_characters.*
import kotlinx.android.synthetic.main.rv_character_item.*

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

        val itemTouchHelperCallback = object: ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val character = charactersAdapter.differ.currentList[position]
                viewModel.deleteCharacter(character = character)
                Snackbar.make(view, "Successfully deleted character ${character.name}", Snackbar.LENGTH_SHORT).apply {
                    setAction("Undo") {
                        viewModel.saveCharacter(character = character)
                    }
                    show()
                }
            }
        }

        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(rvSavedCharacters)
        }

        viewModel.getSavedCharacters().observe(viewLifecycleOwner, Observer { charactersList ->
            charactersAdapter.differ.submitList(charactersList)
        })
    }

    private fun setupRecyclerView() {
        charactersAdapter = CharactersAtapter()
        rvSavedCharacters.apply {
            adapter = charactersAdapter
            layoutManager = GridLayoutManager(activity, 3)
        }
    }
}