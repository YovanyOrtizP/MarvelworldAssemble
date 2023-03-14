package com.yorpe.MarvelWorldAssemble.data.model.series


import com.google.gson.annotations.SerializedName

data class ItemSRespXX(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("resourceURI")
    val resourceURI: String? = "",
    @SerializedName("role")
    val role: String? = ""
)