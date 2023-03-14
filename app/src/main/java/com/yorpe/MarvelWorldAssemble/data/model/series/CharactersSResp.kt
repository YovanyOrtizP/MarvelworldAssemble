package com.yorpe.MarvelWorldAssemble.data.model.series


import com.google.gson.annotations.SerializedName

data class CharactersSResp(
    @SerializedName("available")
    val available: Int? = 0,
    @SerializedName("collectionURI")
    val collectionURI: String? = "",
    @SerializedName("items")
    val items: List<ItemSResp?>? = listOf(),
    @SerializedName("returned")
    val returned: Int? = 0
)