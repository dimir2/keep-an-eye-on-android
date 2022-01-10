package edu.keepaneye.uttermarvel.repository

import edu.keepaneye.uttermarvel.api.RetrofitClient
import edu.keepaneye.uttermarvel.db.MarvelDatabase
import edu.keepaneye.uttermarvel.model.CharacterItem
import edu.keepaneye.uttermarvel.model.ComicsItem

class MarvelRepository(
    val db: MarvelDatabase
) {
    // retrofit
    suspend fun getCharactersList(offset: Int) =
        RetrofitClient.api.getCharactersList(offset = offset)

    suspend fun searchForCharacters(offset: Int, nameStartsWith: String) =
        RetrofitClient.api.searchForCharacters(offset = offset, nameStartsWith = nameStartsWith)

    suspend fun getComicsList(offset: Int) =
        RetrofitClient.api.getComicsList(offset = offset)

    suspend fun searchForComics(offset: Int, titleStartsWith: String) =
        RetrofitClient.api.searchForComics(offset = offset, titleStartsWith = titleStartsWith)

    // db
    suspend fun upsertCharacter(character: CharacterItem) =
        db.getCharacterDao().upsert(character = character)

    fun getSavedCharacters() = db.getCharacterDao().getAllCharacters()

    suspend fun deleteCharacter(character: CharacterItem) =
        db.getCharacterDao().delete(character = character)

    suspend fun upsertComics(comics: ComicsItem) =
        db.getComicsDao().upsert(comics = comics)

    fun getSavedComics() = db.getComicsDao().getAllComics()

    suspend fun deleteComics(comics: ComicsItem) =
        db.getComicsDao().delete(comics = comics)
}
