package com.yorpe.MarvelWorldAssemble.data.model.comics


import com.google.gson.annotations.SerializedName

data class ItemComRes(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("resourceURI")
    val resourceURI: String? = ""
)