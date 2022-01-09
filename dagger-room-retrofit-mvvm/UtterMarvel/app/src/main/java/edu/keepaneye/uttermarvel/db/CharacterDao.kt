package edu.keepaneye.uttermarvel.db

import androidx.lifecycle.LiveData
import androidx.room.*
import edu.keepaneye.uttermarvel.model.CharacterItem

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(character: CharacterItem): Long

    @Query("SELECT * FROM characters")
    fun getAllCharacters(): LiveData<List<CharacterItem>>

    @Delete
    suspend fun deleteCharacter(character: CharacterItem)
}
