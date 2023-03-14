package com.yorpe.MarvelWorldAssemble.data.model.comics


import com.google.gson.annotations.SerializedName

data class PriceComRes(
    @SerializedName("price")
    val price: Double? = 0.0,
    @SerializedName("type")
    val type: String? = ""
)