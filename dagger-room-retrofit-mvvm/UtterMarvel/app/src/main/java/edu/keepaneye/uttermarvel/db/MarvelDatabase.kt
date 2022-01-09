package edu.keepaneye.uttermarvel.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.keepaneye.uttermarvel.model.CharacterItem
import edu.keepaneye.uttermarvel.model.ComicsItem

@Database(
    entities = [CharacterItem::class, ComicsItem::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class MarvelDatabase: RoomDatabase() {
    abstract fun getCharacterDao(): CharacterDao
    abstract fun getComicsDao(): ComicsDao

    companion object {

        @Volatile
        private var instance: MarvelDatabase? = null
        private val LOCK  = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {instance = it}
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MarvelDatabase::class.java,
                "marvel_db.db"
            ).build()
    }
}