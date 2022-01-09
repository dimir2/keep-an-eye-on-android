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
import edu.keepaneye.uttermarvel.adapter.CharactersAtapter
import edu.keepaneye.uttermarvel.ui.MarvelViewModel
import edu.keepaneye.uttermarvel.ui.UtterMarvelActivity
import edu.keepaneye.uttermarvel.utils.Constants
import edu.keepaneye.uttermarvel.utils.Resource
import kotlinx.android.synthetic.main.fragment_characters.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MarvelCharactersFragment : Fragment(R.layout.fragment_characters) {

    lateinit var viewModel: MarvelViewModel
    lateinit var charactersAdapter: CharactersAtapter

    val TAG = "MarvelCharactersFragment"

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = (activity as UtterMarvelActivity).viewModel
        viewModel.getCharactersList()

        setupRecyclerView()

        charactersAdapter.setOnItemClickListener { character ->
            val bundle = Bundle().apply {
                putSerializable("character", character)
            }
            findNavController().navigate(
                R.id.action_marvelCharactersFragment_to_marvelCharacterItemFragment,
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
                        viewModel.searchForCharacters(nameStartsWith = editable.toString())
                    } else {
                        viewModel.getCharactersList()
                    }
                }
            }
        }

        viewModel.charactersList.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Loading -> {
                    showProgressBar()
                }
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { charactersResponse ->
                        charactersAdapter.differ.submitList(charactersResponse.data.results)
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
        charactersAdapter = CharactersAtapter()
        rvCharacters.apply {
            adapter = charactersAdapter
            layoutManager = GridLayoutManager(activity, 3)
        }
    }
}