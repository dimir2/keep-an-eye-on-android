package edu.keepaneye.rickandmorty.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.keepaneye.rickandmorty.data.entities.Character
import edu.keepaneye.rickandmorty.data.repository.CharacterRepository
import edu.keepaneye.rickandmorty.utils.Resource
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel(){
    val characters: LiveData<Resource<List<Character>>> = repository.getCharacters()
}