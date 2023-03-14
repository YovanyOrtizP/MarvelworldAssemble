package com.yorpe.MarvelWorldAssemble.data.model.comics


import com.google.gson.annotations.SerializedName

data class ImageComRes(
    @SerializedName("extension")
    val extension: String? = "",
    @SerializedName("path")
    val path: String? = ""
)