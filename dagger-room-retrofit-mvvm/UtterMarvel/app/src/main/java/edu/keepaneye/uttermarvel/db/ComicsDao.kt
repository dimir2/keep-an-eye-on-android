package edu.keepaneye.uttermarvel.db

import androidx.lifecycle.LiveData
import androidx.room.*
import edu.keepaneye.uttermarvel.model.CharacterItem
import edu.keepaneye.uttermarvel.model.ComicsItem

@Dao
interface ComicsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(comics: ComicsItem): Long

    @Query("SELECT * FROM comics")
    fun getAllComics(): LiveData<List<ComicsItem>>

    @Delete
    suspend fun deleteCharacter(comics: ComicsItem)
}
