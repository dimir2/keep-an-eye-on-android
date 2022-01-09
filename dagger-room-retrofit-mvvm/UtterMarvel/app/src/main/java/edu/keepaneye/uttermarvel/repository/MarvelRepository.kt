package edu.keepaneye.uttermarvel.repository

import edu.keepaneye.uttermarvel.api.RetrofitClient
import edu.keepaneye.uttermarvel.db.MarvelDatabase

class MarvelRepository(
    val db: MarvelDatabase
) {
    suspend fun getCharactersList(offset: Int) =
        RetrofitClient.api.getCharactersList(offset = offset)

    suspend fun searchForCharacters(offset: Int, nameStartsWith: String) =
        RetrofitClient.api.searchForCharacters(offset = offset, nameStartsWith = nameStartsWith)

    suspend fun getComicsList(offset: Int) =
        RetrofitClient.api.getComicsList(offset = offset)

    suspend fun searchForComics(offset: Int, titleStartsWith: String) =
        RetrofitClient.api.searchForComics(offset = offset, titleStartsWith = titleStartsWith)
}
