package com.yorpe.MarvelWorldAssemble.data.remote

import com.yorpe.MarvelWorldAssemble.data.model.characters.CharactersResponse
import com.yorpe.MarvelWorldAssemble.data.model.comics.ComicsResponse
import com.yorpe.MarvelWorldAssemble.data.model.series.SeriesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {
    /**
     * Characters:
     * https://gateway.marvel.com/v1/public/characters?ts=1&apikey=5399470a8b11f4e76d54a2c69adf1e7c&hash=48d040468da4940482b1cb36158e315e
     *Series:
     * https://gateway.marvel.com/v1/public/series?ts=1&apikey=5399470a8b11f4e76d54a2c69adf1e7c&hash=48d040468da4940482b1cb36158e315e
     * Comics:
     * https://gateway.marvel.com/v1/public/comics?ts=1&apikey=5399470a8b11f4e76d54a2c69adf1e7c&hash=48d040468da4940482b1cb36158e315e
     */

    @GET(ENDPOINT_CHARACTER)
    suspend fun getCharacters(
        @Query(SEARCH_CHARACTER) nameStartsWith: String? = null,
        @Query(PARAM_LIMIT)paramLimit:Int,
        @Query(PARAM_TS) paramTs :String,
        @Query(PARAM_KEY) apiKey:String,
        @Query(PARAM_HASH) hash:String
    ):Response<CharactersResponse>

    @GET(ENDPOINT_SERIES)
    suspend fun getSeries(
        @Query(SEARCH) titleStartsWith: String? = null,
        @Query(PARAM_LIMIT)paramLimit:Int,
        @Query(PARAM_TS) paramTs :String,
        @Query(PARAM_KEY) apiKey:String,
        @Query(PARAM_HASH) hash:String
    ):Response<SeriesResponse>

    @GET(ENDPOINT_COMICS)
    suspend fun getComics(
        @Query(SEARCH) titleStartsWith: String? = null,
        @Query(PARAM_LIMIT)paramLimit:Int,
        @Query(PARAM_TS) paramTs :String,
        @Query(PARAM_KEY) apiKey:String,
        @Query(PARAM_HASH) hash:String
    ):Response<ComicsResponse>

    companion object{
        const val BASE_URL = "https://gateway.marvel.com"
        const val ENDPOINT_CHARACTER = "/v1/public/characters"
        const val ENDPOINT_SERIES = "/v1/public/series"
        const val ENDPOINT_COMICS = "/v1/public/comics"
        const val PARAM_TS = "ts"
        const val PARAM_KEY = "apikey"
        const val PARAM_HASH = "hash"
        const val PARAM_LIMIT = "limit"
        const val SEARCH_CHARACTER= "nameStartsWith"
        const val SEARCH= "titleStartsWith"
        const val TS = "1"
        const val APIKEY = "5399470a8b11f4e76d54a2c69adf1e7c"
        const val HASH = "48d040468da4940482b1cb36158e315e"
        const val LIMIT = 100
    }
}



//@GET(ENDPOINT)
//fun getNextBookPage(
//    @Query(PARAM_Q) bookTitle:String,
//    @Query(PARAM_FILTER) bookFilter: String,
//    @Query(PARAM_PRINT_TYPE) bookType: String,
//    @Query(PARAM_START_INDEX) pageIndex: Int
//): Call<BookResponse>