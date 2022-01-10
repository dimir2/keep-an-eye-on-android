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
import kotlinx.android.synthetic.main.fragment_comics_item.*
import kotlinx.android.synthetic.main.fragment_comics_item.view.*
import kotlinx.android.synthetic.main.rv_character_item.view.ivItemImage

class MarvelComicsItemFragment : Fragment(R.layout.fragment_comics_item) {
    lateinit var viewModel: MarvelViewModel
    val args: MarvelComicsItemFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as UtterMarvelActivity).viewModel
        val comics = args.comics

        view.apply {
            Glide
                .with(this)
                .load("${comics.thumbnail.path}.${comics.thumbnail.extension}")
                .into(ivItemImage)
            tvItemTitle.text = comics.title
        }
        fab.setOnClickListener {
            viewModel.saveComics(comics = comics)
            Snackbar.make(view, "Comics ${comics.title} saved successfully", Snackbar.LENGTH_SHORT).show()
        }
    }
}