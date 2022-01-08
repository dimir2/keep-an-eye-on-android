package edu.keepaneye.uttermarvel.model

data class ResponseDTO(
    var code: Int,
    var status: String,
    var data: ResponseData
)

data class ResponseData(
    var offset: Int,
    var limit: Int,
    var total: Int,
    var count: Int,
    var results: MutableList<ResponseItem>
)

data class ResponseItem(
    var id: Int,
    var title: String,
    var thumbnail: ResponseThumbnail
)

class ResponseThumbnail(
    var path: String,
    var extension: String
)
