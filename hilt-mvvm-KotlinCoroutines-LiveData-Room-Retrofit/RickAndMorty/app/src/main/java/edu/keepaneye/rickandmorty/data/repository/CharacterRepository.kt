package edu.keepaneye.rickandmorty.data.repository

import edu.keepaneye.rickandmorty.data.local.CharacterDao
import edu.keepaneye.rickandmorty.data.remote.CharacterRemoteDataSource
import edu.keepaneye.rickandmorty.utils.performGetOperation
import edu.keepaneye.rickandmorty.data.entities.Character
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val remoteDataSource: CharacterRemoteDataSource,
    private val localDataSource: CharacterDao
) {

    fun getCharacter(id: Int) = performGetOperation(
        databaseQuery = { localDataSource.getCharacter(id) },
        networkCall = { remoteDataSource.getCharacter(id) },
        saveCallResult = {character: Character ->
            localDataSource.insert(character) }
    )

    fun getCharacters() = performGetOperation(
        databaseQuery = { localDataSource.getAllCharacters() },
        networkCall = { remoteDataSource.getCharacters() },
        saveCallResult = { localDataSource.insertAll(it.results) }
    )
}