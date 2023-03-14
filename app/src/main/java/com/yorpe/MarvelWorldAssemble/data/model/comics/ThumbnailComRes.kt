package com.yorpe.MarvelWorldAssemble.data.model.comics


import com.google.gson.annotations.SerializedName

data class ThumbnailComRes(
    @SerializedName("extension")
    val extension: String? = "",
    @SerializedName("path")
    val path: String? = ""
)