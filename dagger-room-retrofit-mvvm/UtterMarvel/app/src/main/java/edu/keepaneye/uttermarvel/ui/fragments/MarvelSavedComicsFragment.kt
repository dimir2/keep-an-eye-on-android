package edu.keepaneye.uttermarvel.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import edu.keepaneye.uttermarvel.R
import edu.keepaneye.uttermarvel.adapter.ComicsAtapter
import edu.keepaneye.uttermarvel.ui.MarvelViewModel
import edu.keepaneye.uttermarvel.ui.UtterMarvelActivity
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
    }

    private fun setupRecyclerView() {
        comicsAdapter = ComicsAtapter()
        rvSavedComics.apply {
            adapter = comicsAdapter
            layoutManager = GridLayoutManager(activity, 3)
        }
    }
}