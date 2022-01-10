package edu.keepaneye.uttermarvel.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

data class CharactersResponse(
    var code: Int,
    var status: String,
    var data: CharactersResponseData
)

data class CharactersResponseData(
    var offset: Int,
    var limit: Int,
    var total: Int,
    var count: Int,
    var results: MutableList<CharacterItem>
)

@Entity(
    tableName = "characters"
)
data class CharacterItem(
//    @PrimaryKey(autoGenerate = true)
//    var key: Int? = null,
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var name: String,
    var thumbnail: Thumbnail
): Serializable

data class Thumbnail(
    var path: String,
    var extension: String
)
