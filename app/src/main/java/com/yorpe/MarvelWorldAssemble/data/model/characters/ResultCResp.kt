package com.yorpe.MarvelWorldAssemble.data.model.characters


import com.google.gson.annotations.SerializedName

data class ResultCResp(
    @SerializedName("comics")
    val comics: ComicsCResp? = ComicsCResp(),
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("events")
    val events: EventsCResp? = EventsCResp(),
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("modified")
    val modified: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("resourceURI")
    val resourceURI: String? = "",
    @SerializedName("series")
    val series: SeriesCResp? = SeriesCResp(),
    @SerializedName("stories")
    val stories: StoriesCResp? = StoriesCResp(),
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailCResp? = ThumbnailCResp(),
    @SerializedName("urls")
    val urls: List<UrlCResp>? = listOf()
)