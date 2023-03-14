package com.yorpe.MarvelWorldAssemble.data.model.characters


import com.google.gson.annotations.SerializedName

data class DataCResp(
    @SerializedName("count")
    val count: Int? = 0,
    @SerializedName("limit")
    val limit: Int? = 0,
    @SerializedName("offset")
    val offset: Int? = 0,
    @SerializedName("results")
    val results: List<ResultCResp>? = listOf(),
    @SerializedName("total")
    val total: Int? = 0
)