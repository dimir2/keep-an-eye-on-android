package edu.keepaneye.uttermarvel.db

import androidx.room.TypeConverter
import edu.keepaneye.uttermarvel.model.Thumbnail
import java.io.File

class Converters {
    @TypeConverter
    fun fromThumbnail(thumbnail: Thumbnail): String {
        return "${thumbnail.path}.${thumbnail.extension}"
    }
    @TypeConverter
    fun toThumbnail(path: String): Thumbnail {
        val f = File(path)
        return Thumbnail(f.nameWithoutExtension, f.extension)
    }
}