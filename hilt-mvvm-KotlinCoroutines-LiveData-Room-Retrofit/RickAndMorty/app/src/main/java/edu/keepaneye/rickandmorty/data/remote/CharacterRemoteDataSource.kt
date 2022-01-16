package edu.keepaneye.rickandmorty.data.remote

import javax.inject.Inject
import edu.keepaneye.rickandmorty.data.entities.Character
import edu.keepaneye.rickandmorty.data.entities.CharacterList
import edu.keepaneye.rickandmorty.utils.Resource

class CharacterRemoteDataSource @Inject constructor(
    private val characterService: CharacterService
    ) : BaseDataSource() {
    suspend fun getCharacters() : Resource<CharacterList> = getResult { characterService.getAllCharacters() }
    suspend fun getCharacter(id: Int) : Resource<Character> = getResult { characterService.getCharacter(id) }
}
