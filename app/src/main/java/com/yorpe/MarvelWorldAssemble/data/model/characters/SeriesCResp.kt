package com.yorpe.MarvelWorldAssemble.data.model.characters


import com.google.gson.annotations.SerializedName

data class SeriesCResp(
    @SerializedName("available")
    val available: Int? = 0,
    @SerializedName("collectionURI")
    val collectionURI: String? = "",
    @SerializedName("items")
    val items: List<ItemCResp>? = listOf(),
    @SerializedName("returned")
    val returned: Int? = 0
)