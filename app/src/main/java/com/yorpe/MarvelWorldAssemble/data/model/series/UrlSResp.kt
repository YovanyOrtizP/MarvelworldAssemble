package com.yorpe.MarvelWorldAssemble.data.model.series


import com.google.gson.annotations.SerializedName

data class UrlSResp(
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("url")
    val url: String? = ""
)