package com.yorpe.MarvelWorldAssemble.data.model.characters


import com.google.gson.annotations.SerializedName

data class ThumbnailCResp(
    @SerializedName("extension")
    val extension: String? = "",
    @SerializedName("path")
    val path: String? = ""
)