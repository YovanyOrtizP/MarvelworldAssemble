package com.yorpe.MarvelWorldAssemble.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yorpe.MarvelWorldAssemble.data.model.characters.CharactersResponse
import com.yorpe.MarvelWorldAssemble.data.model.characters.ResultCResp
import com.yorpe.MarvelWorldAssemble.data.model.comics.ComicsResponse
import com.yorpe.MarvelWorldAssemble.data.model.comics.ResultComRes
import com.yorpe.MarvelWorldAssemble.data.model.series.ResultSResp
import com.yorpe.MarvelWorldAssemble.data.model.series.SeriesResponse
import com.yorpe.MarvelWorldAssemble.data.repository.MarvelRepository
import com.yorpe.MarvelWorldAssemble.util.ResponseType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GeneralViewModel @Inject constructor(
    private val marvelRepository: MarvelRepository
) : ViewModel() {

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    var charObject: ResultCResp? = null
    private val _resultCharacters = MutableLiveData<ResponseType<CharactersResponse>>()
    val resultCharacters: LiveData<ResponseType<CharactersResponse>> = _resultCharacters

    var seriesObject: ResultSResp? = null
    private val _resultSeries = MutableLiveData<ResponseType<SeriesResponse>>()
    val resultSeries: LiveData<ResponseType<SeriesResponse>> = _resultSeries

    var comicsObject: ResultComRes? = null
    private val _resultComics = MutableLiveData<ResponseType<ComicsResponse>>()
    val resultComics: LiveData<ResponseType<ComicsResponse>> = _resultComics


    fun flowComics(nameStartsWith: String? = null) {
        viewModelScope.launch(ioDispatcher) {
            marvelRepository.getComicsFlow(nameStartsWith).collect() {
                _resultComics.postValue(it)
            }
        }
    }

    fun flowSeries(nameStartsWith: String? = null) {
        viewModelScope.launch(ioDispatcher) {
            marvelRepository.getSeriesFlow(nameStartsWith).collect() {
                _resultSeries.postValue(it)
            }
        }
    }

    fun flowCharacters(nameStartsWith: String? = null) {
        viewModelScope.launch(ioDispatcher) {
            marvelRepository.getCharactersFlow(nameStartsWith).collect() {
                _resultCharacters.postValue(it)
            }
        }
    }
}