package com.yorpe.MarvelWorldAssemble.data.repository

import com.yorpe.MarvelWorldAssemble.data.model.characters.CharactersResponse
import com.yorpe.MarvelWorldAssemble.data.model.comics.ComicsResponse
import com.yorpe.MarvelWorldAssemble.data.model.series.SeriesResponse
import com.yorpe.MarvelWorldAssemble.data.remote.MarvelApi
import com.yorpe.MarvelWorldAssemble.data.remote.MarvelApi.Companion.APIKEY
import com.yorpe.MarvelWorldAssemble.data.remote.MarvelApi.Companion.HASH
import com.yorpe.MarvelWorldAssemble.data.remote.MarvelApi.Companion.LIMIT
import com.yorpe.MarvelWorldAssemble.data.remote.MarvelApi.Companion.TS
import com.yorpe.MarvelWorldAssemble.util.ResponseType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val marvelApi: MarvelApi
) : MarvelRepository {
    override fun getCharactersFlow(nameStartsWith: String?): Flow<ResponseType<CharactersResponse>> = flow{
        emit(ResponseType.LOADING)

        try {
            val response = if(nameStartsWith != null) {
                marvelApi.getCharacters(nameStartsWith,LIMIT,TS, APIKEY, HASH)
            }else{
                marvelApi.getCharacters(null,LIMIT,TS, APIKEY, HASH)
            }
            if(response.isSuccessful){
                response.body()?.let { info ->
                    emit(ResponseType.SUCCESS(info))
                }
            }else{
                emit(ResponseType.ERROR(response.message()))
            }
        }catch (e:java.lang.Exception){
            emit(ResponseType.ERROR(e.localizedMessage))
        }
    }

    override fun getSeriesFlow(titleStartsWith: String?): Flow<ResponseType<SeriesResponse>> = flow{
        emit(ResponseType.LOADING)

        try {
            val response = if(titleStartsWith != null) {
                marvelApi.getSeries(titleStartsWith,LIMIT,TS, APIKEY, HASH)
            }else {
                marvelApi.getSeries(null, LIMIT, TS, APIKEY, HASH)
            }
            if(response.isSuccessful){
                response.body()?.let { info ->
                    emit(ResponseType.SUCCESS(info))
                }
            }else{
                emit(ResponseType.ERROR(response.message()))
            }
        }catch (e:java.lang.Exception){
            emit(ResponseType.ERROR(e.localizedMessage))
        }
    }

    override fun getComicsFlow(titleStartsWith: String?): Flow<ResponseType<ComicsResponse>> = flow{
        emit(ResponseType.LOADING)

        try {
            val response = if(titleStartsWith != null) {
                marvelApi.getComics(titleStartsWith,LIMIT,TS, APIKEY, HASH)
            }else {
                marvelApi.getComics(null, LIMIT, TS, APIKEY, HASH)
            }
            if(response.isSuccessful){
                response.body()?.let { info ->
                    emit(ResponseType.SUCCESS(info))
                }
            }else{
                emit(ResponseType.ERROR(response.message()))
            }
        }catch (e:java.lang.Exception){
            emit(ResponseType.ERROR(e.localizedMessage))
        }
    }
}