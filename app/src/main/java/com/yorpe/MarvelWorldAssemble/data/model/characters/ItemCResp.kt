package com.yorpe.MarvelWorldAssemble.data.model.characters


import com.google.gson.annotations.SerializedName

data class ItemCResp(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("resourceURI")
    val resourceURI: String? = ""
)