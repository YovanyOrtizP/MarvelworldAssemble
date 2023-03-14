package com.yorpe.MarvelWorldAssemble.data.model.series


import com.google.gson.annotations.SerializedName

data class StoriesSResp(
    @SerializedName("available")
    val available: Int? = 0,
    @SerializedName("collectionURI")
    val collectionURI: String? = "",
    @SerializedName("items")
    val items: List<ItemSRespXXX>? = listOf(),
    @SerializedName("returned")
    val returned: Int? = 0
)