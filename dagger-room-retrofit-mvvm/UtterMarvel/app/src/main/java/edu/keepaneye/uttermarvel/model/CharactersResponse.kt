package edu.keepaneye.uttermarvel.model

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

data class CharacterItem(
    var id: Int,
    var title: String,
    var thumbnail: Thumbnail
)

data class Thumbnail(
    var path: String,
    var extension: String
)
