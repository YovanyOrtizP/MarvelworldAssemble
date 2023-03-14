package com.yorpe.MarvelWorldAssemble.data.model.characters


import com.google.gson.annotations.SerializedName

data class UrlCResp(
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("url")
    val url: String? = ""
)