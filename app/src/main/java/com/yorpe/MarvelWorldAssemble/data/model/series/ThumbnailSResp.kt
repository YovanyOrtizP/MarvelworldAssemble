package com.yorpe.MarvelWorldAssemble.data.model.series


import com.google.gson.annotations.SerializedName

data class ThumbnailSResp(
    @SerializedName("extension")
    val extension: String? = "",
    @SerializedName("path")
    val path: String? = ""
)