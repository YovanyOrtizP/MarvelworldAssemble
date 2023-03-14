package com.yorpe.MarvelWorldAssemble.data.model.comics


import com.google.gson.annotations.SerializedName

data class DateComRes(
    @SerializedName("date")
    val date: String? = "",
    @SerializedName("type")
    val type: String? = ""
)