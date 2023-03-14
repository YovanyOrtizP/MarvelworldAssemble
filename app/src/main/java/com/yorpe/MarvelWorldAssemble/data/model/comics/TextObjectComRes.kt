package com.yorpe.MarvelWorldAssemble.data.model.comics


import com.google.gson.annotations.SerializedName

data class TextObjectComRes(
    @SerializedName("language")
    val language: String? = "",
    @SerializedName("text")
    val text: String? = "",
    @SerializedName("type")
    val type: String? = ""
)