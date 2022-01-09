package edu.keepaneye.uttermarvel.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

data class ComicsResponse(
    var code: Int,
    var status: String,
    var data: ComicsResponseData
)

data class ComicsResponseData(
    var offset: Int,
    var limit: Int,
    var total: Int,
    var count: Int,
    var results: MutableList<ComicsItem>
)

@Entity(
    tableName = "comics"
)
data class ComicsItem(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var title: String,
    var thumbnail: Thumbnail
) : Serializable
