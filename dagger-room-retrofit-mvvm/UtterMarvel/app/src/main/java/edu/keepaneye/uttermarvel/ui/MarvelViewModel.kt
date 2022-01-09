package edu.keepaneye.uttermarvel.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.keepaneye.uttermarvel.model.CharactersResponse
import edu.keepaneye.uttermarvel.model.ComicsResponse
import edu.keepaneye.uttermarvel.repository.MarvelRepository
import edu.keepaneye.uttermarvel.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MarvelViewModel(
    val marvelRepository : MarvelRepository
): ViewModel() {

    val charactersList: MutableLiveData<Resource<CharactersResponse>> = MutableLiveData()
    var charactersListOffset = 0
    var searchCharactersListOffset = 0

    val comicsList: MutableLiveData<Resource<ComicsResponse>> = MutableLiveData()
    var comicsListOffset = 0
    var searchComicsListOffset = 0

    fun getCharactersList() = viewModelScope.launch {
        charactersList.postValue(Resource.Loading())
        val response = marvelRepository.getCharactersList(offset = charactersListOffset)
        charactersList.postValue(handleCharacterListResponse(response))
    }

    fun searchForCharacters(nameStartsWith : String) = viewModelScope.launch {
        charactersList.postValue(Resource.Loading())
        val response = marvelRepository.searchForCharacters(offset = searchCharactersListOffset, nameStartsWith = nameStartsWith)
        charactersList.postValue(handleSearchForCharactersResponse(response))
    }

    fun getComicsList() = viewModelScope.launch {
        comicsList.postValue(Resource.Loading())
        val response = marvelRepository.getComicsList(offset = comicsListOffset)
        comicsList.postValue(handleComicsListResponse(response))
    }

    fun searchForComics(titleStartsWith : String) = viewModelScope.launch {
        comicsList.postValue(Resource.Loading())
        val response = marvelRepository.searchForComics(offset = searchComicsListOffset, titleStartsWith = titleStartsWith)
        comicsList.postValue(handleSearchForComicsResponse(response))
    }

    private fun handleCharacterListResponse(response: Response<CharactersResponse>) : Resource<CharactersResponse> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return  Resource.Error(response.message())
    }

    private fun handleSearchForCharactersResponse(response: Response<CharactersResponse>) : Resource<CharactersResponse> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return  Resource.Error(response.message())
    }


    private fun handleComicsListResponse(response: Response<ComicsResponse>) : Resource<ComicsResponse> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return  Resource.Error(response.message())
    }

    private fun handleSearchForComicsResponse(response: Response<ComicsResponse>) : Resource<ComicsResponse> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return  Resource.Error(response.message())
    }
}