package edu.keepaneye.uttermarvel.utils

import edu.keepaneye.uttermarvel.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

class Constants {
    companion object {
        val timestamp: String = Calendar.getInstance().time.time.toString()

        const val API_KEY = BuildConfig.MARVEL_PUBLIC_KEY
        const val PRIVATE_KEY = BuildConfig.MARVEL_PRIVATE_KEY
        const val BASE_URL = BuildConfig.BASE_URL
        const val HASH_ALGORITHM = "MD5"

        fun hash(): String {
            val secret = "$timestamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance(HASH_ALGORITHM)
            return BigInteger(1, md.digest(secret.toByteArray())).toString(16).padStart(32, '0')
        }
    }
}