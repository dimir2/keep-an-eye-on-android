package edu.keepaneye.uttermarvel.model

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

data class ComicsItem(
    var id: Int,
    var title: String,
    var thumbnail: Thumbnail
)
