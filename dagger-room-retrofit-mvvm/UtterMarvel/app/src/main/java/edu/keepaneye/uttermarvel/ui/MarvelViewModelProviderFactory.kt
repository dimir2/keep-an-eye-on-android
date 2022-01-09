package edu.keepaneye.uttermarvel.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.keepaneye.uttermarvel.repository.MarvelRepository

class MarvelViewModelProviderFactory(
    val marvelRepository: MarvelRepository

) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MarvelViewModel(marvelRepository) as T
    }
}