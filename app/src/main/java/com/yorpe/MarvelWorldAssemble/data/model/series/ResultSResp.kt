package com.yorpe.MarvelWorldAssemble.data.model.series


import com.google.gson.annotations.SerializedName

data class ResultSResp(
    @SerializedName("characters")
    val characters: CharactersSResp? = CharactersSResp(),
    @SerializedName("comics")
    val comics: ComicsSResp? = ComicsSResp(),
    @SerializedName("creators")
    val creators: CreatorsSResp? = CreatorsSResp(),
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("endYear")
    val endYear: Int? = 0,
    @SerializedName("events")
    val events: EventsSResp? = EventsSResp(),
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("modified")
    val modified: String? = "",
    @SerializedName("next")
    val next: NextSResp? = NextSResp(),
    @SerializedName("previous")
    val previous: Any? = Any(),
    @SerializedName("rating")
    val rating: String? = "",
    @SerializedName("resourceURI")
    val resourceURI: String? = "",
    @SerializedName("startYear")
    val startYear: Int? = 0,
    @SerializedName("stories")
    val stories: StoriesSResp? = StoriesSResp(),
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailSResp? = ThumbnailSResp(),
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("urls")
    val urls: List<UrlSResp>? = listOf()
)