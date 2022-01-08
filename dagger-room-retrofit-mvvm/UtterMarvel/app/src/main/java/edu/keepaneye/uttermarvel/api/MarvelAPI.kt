package edu.keepaneye.uttermarvel.api

import edu.keepaneye.uttermarvel.model.CharactersResponse
import edu.keepaneye.uttermarvel.model.ComicsResponse
import edu.keepaneye.uttermarvel.utils.Constants
import edu.keepaneye.uttermarvel.utils.Constants.Companion.BASE_URL
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPI {

    @GET("/v1/public/characters")
    suspend fun getCharacterList(
        @Query (value = "ts")
        timestamp: String = Constants.timestamp,
        @Query (value = "apikey")
        apikey: String = Constants.API_KEY,
        @Query (value = "hash")
        hash: String = Constants.hash(),
        @Query (value = "offset")
        offset: Int = 0
    ): Response<CharactersResponse>

    @GET("/v1/public/comics")
    suspend fun getComicsList(
        @Query (value = "ts")
        timestamp: String = Constants.timestamp,
        @Query (value = "apikey")
        apikey: String = Constants.API_KEY,
        @Query (value = "hash")
        hash: String = Constants.hash(),
        @Query (value = "offset")
        offset: Int = 0
    ): Response<ComicsResponse>


    @GET("/v1/public/characters")
    suspend fun searchForCharacters(
        @Query (value = "ts")
        timestamp: String = Constants.timestamp,
        @Query (value = "apikey")
        apikey: String = Constants.API_KEY,
        @Query (value = "hash")
        hash: String = Constants.hash(),
        @Query (value = "offset")
        offset: Int = 0,
        @Query (value = "nameStartsWith")
        nameStartsWith: String = ""
    ): Response<CharactersResponse>

    @GET("/v1/public/comics")
    suspend fun searchForComics(
        @Query (value = "ts")
        timestamp: String = Constants.timestamp,
        @Query (value = "apikey")
        apikey: String = Constants.API_KEY,
        @Query (value = "hash")
        hash: String = Constants.hash(),
        @Query (value = "offset")
        offset: Int = 0,
        @Query (value = "titleStartsWith")
        titleStartsWith: String = ""
    ): Response<ComicsResponse>

}