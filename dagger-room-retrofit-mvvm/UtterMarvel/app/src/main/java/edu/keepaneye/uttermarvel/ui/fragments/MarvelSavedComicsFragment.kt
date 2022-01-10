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
import edu.keepaneye.uttermarvel.adapter.ComicsAtapter
import edu.keepaneye.uttermarvel.ui.MarvelViewModel
import edu.keepaneye.uttermarvel.ui.UtterMarvelActivity
import kotlinx.android.synthetic.main.fragment_saved_characters.*
import kotlinx.android.synthetic.main.fragment_saved_comics.*

class MarvelSavedComicsFragment : Fragment(R.layout.fragment_saved_comics) {

    lateinit var viewModel: MarvelViewModel
    lateinit var comicsAdapter: ComicsAtapter

    val TAG = "MarvelSavedComicsFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as UtterMarvelActivity).viewModel

        setupRecyclerView()

        comicsAdapter.setOnItemClickListener { comics ->
            val bundle = Bundle().apply {
                putSerializable("comics", comics)
            }
            findNavController().navigate(
                R.id.action_marvelSavedComicsFragment_to_marvelComicsItemFragment,
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
                val comics = comicsAdapter.differ.currentList[position]
                viewModel.deleteComics(comics = comics)
                Snackbar.make(view, "Successfully deleted comics ${comics.title}", Snackbar.LENGTH_SHORT).apply {
                    setAction("Undo") {
                        viewModel.saveComics(comics = comics)
                    }
                    show()
                }
            }
        }

        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(rvSavedComics)
        }

        viewModel.getSavedComics().observe(viewLifecycleOwner, Observer { comicsList ->
            comicsAdapter.differ.submitList(comicsList)
        })
    }

    private fun setupRecyclerView() {
        comicsAdapter = ComicsAtapter()
        rvSavedComics.apply {
            adapter = comicsAdapter
            layoutManager = GridLayoutManager(activity, 3)
        }
    }
}