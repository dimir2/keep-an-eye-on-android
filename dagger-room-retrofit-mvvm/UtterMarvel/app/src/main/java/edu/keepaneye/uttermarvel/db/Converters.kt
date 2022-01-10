package edu.keepaneye.uttermarvel.db

import androidx.room.TypeConverter
import edu.keepaneye.uttermarvel.model.Thumbnail

class Converters {
    @TypeConverter
    fun fromThumbnail(thumbnail: Thumbnail): String {
        return "${thumbnail.path}.${thumbnail.extension}"
    }

    @TypeConverter
    fun toThumbnail(url: String): Thumbnail {
        val extension: String = url.substring(url.lastIndexOf('.') + 1, url.length)
        val path = url.substring(0, url.lastIndexOf('.'))
        return Thumbnail(path = path, extension = extension)
    }
}