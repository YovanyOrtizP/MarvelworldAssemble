package com.yorpe.MarvelWorldAssemble.util

sealed class ResponseType<out T>{

    object LOADING : ResponseType<Nothing>()

    data class SUCCESS<T>(val response: T): ResponseType<T>()

    class ERROR(val e: String): ResponseType<Nothing>()
}