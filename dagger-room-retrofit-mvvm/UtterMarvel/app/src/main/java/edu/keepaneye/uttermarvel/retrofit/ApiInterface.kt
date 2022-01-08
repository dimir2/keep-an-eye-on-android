package edu.keepaneye.uttermarvel.retrofit

import edu.keepaneye.uttermarvel.model.ResponseDTO
import edu.keepaneye.uttermarvel.utils.Constants.Companion.BASE_URL
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/v1/public/characters")
    fun getCharacterList(): Call<ResponseDTO>

    @GET("/v1/public/comics")
    fun getComicsList(): Call<ResponseDTO>

    companion object {
        fun create() : ApiInterface {
            return RetrofitClient.getClient(BASE_URL).create(ApiInterface::class.java)
        }
    }
}