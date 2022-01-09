package edu.keepaneye.uttermarvel.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import edu.keepaneye.uttermarvel.R
import edu.keepaneye.uttermarvel.adapter.ComicsAtapter
import edu.keepaneye.uttermarvel.ui.MarvelViewModel
import edu.keepaneye.uttermarvel.ui.UtterMarvelActivity
import edu.keepaneye.uttermarvel.utils.Constants
import edu.keepaneye.uttermarvel.utils.Resource
import kotlinx.android.synthetic.main.fragment_comics.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MarvelComicsFragment:Fragment(R.layout.fragment_comics){

    lateinit var viewModel: MarvelViewModel
    lateinit var comicsAdapter: ComicsAtapter

    val TAG = "MarvelComicsFragment"

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = (activity as UtterMarvelActivity).viewModel
        viewModel.getComicsList()

        setupRecyclerView()

        comicsAdapter.setOnItemClickListener { comics ->
            val bundle = Bundle().apply {
                putSerializable("comics", comics)
            }
            findNavController().navigate(
                R.id.action_marvelComicsFragment_to_marvelComicsItemFragment,
                bundle
            )
        }
        var job: Job? = null
        etSearch.addTextChangedListener { editable ->
            job?.cancel()
            job = MainScope().launch {
                delay(Constants.SEARCH_DELAY)
                editable?.let {
                    if (editable.toString().isNotEmpty()) {
                        viewModel.searchForComics(titleStartsWith = editable.toString())
                    } else {
                        viewModel.getComicsList()
                    }
                }
            }
        }

        viewModel.comicsList.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Loading -> {
                    showProgressBar()
                }
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { comicsResponse ->
                        comicsAdapter.differ.submitList(comicsResponse.data.results)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG, "An error occurred : $message")
                    }
                }
            }
        })
    }

    private fun hideProgressBar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        comicsAdapter = ComicsAtapter()
        rvComics.apply {
            adapter = comicsAdapter
            layoutManager = GridLayoutManager(activity, 3)
        }
    }
}