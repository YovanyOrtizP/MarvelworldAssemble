package com.yorpe.MarvelWorldAssemble.data.repository

import com.yorpe.MarvelWorldAssemble.data.model.characters.CharactersResponse
import com.yorpe.MarvelWorldAssemble.data.model.comics.ComicsResponse
import com.yorpe.MarvelWorldAssemble.data.model.series.SeriesResponse
import com.yorpe.MarvelWorldAssemble.util.ResponseType
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {

    fun getCharactersFlow(nameStartsWith: String? = null): Flow<ResponseType<CharactersResponse>>

    fun getSeriesFlow(titleStartsWith: String? = null): Flow<ResponseType<SeriesResponse>>

    fun getComicsFlow(titleStartsWith: String? = null): Flow<ResponseType<ComicsResponse>>
}