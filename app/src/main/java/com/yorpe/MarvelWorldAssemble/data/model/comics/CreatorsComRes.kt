package com.yorpe.MarvelWorldAssemble.data.model.comics


import com.google.gson.annotations.SerializedName

data class CreatorsComRes(
    @SerializedName("available")
    val available: Int? = 0,
    @SerializedName("collectionURI")
    val collectionURI: String? = "",
    @SerializedName("items")
    val items: List<ItemComResX>? = listOf(),
    @SerializedName("returned")
    val returned: Int? = 0
)