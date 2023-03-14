package com.yorpe.MarvelWorldAssemble.data.model.comics


import com.google.gson.annotations.SerializedName

data class ResultComRes(
    @SerializedName("characters")
    val characters: CharactersComRes? = CharactersComRes(),
    @SerializedName("collectedIssues")
    val collectedIssues: List<CollectedIssueComRes>? = listOf(),
    @SerializedName("collections")
    val collections: List<Any>? = listOf(),
    @SerializedName("creators")
    val creators: CreatorsComRes? = CreatorsComRes(),
    @SerializedName("dates")
    val dates: List<DateComRes>? = listOf(),
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("diamondCode")
    val diamondCode: String? = "",
    @SerializedName("digitalId")
    val digitalId: Int? = 0,
    @SerializedName("ean")
    val ean: String? = "",
    @SerializedName("events")
    val events: EventsComRes? = null,
    @SerializedName("format")
    val format: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("images")
    val images: List<ImageComRes>? = listOf(),
    @SerializedName("isbn")
    val isbn: String? = "",
    @SerializedName("issn")
    val issn: String? = "",
    @SerializedName("issueNumber")
    val issueNumber: Int? = 0,
    @SerializedName("modified")
    val modified: String? = "",
    @SerializedName("pageCount")
    val pageCount: Int? = 0,
    @SerializedName("prices")
    val prices: List<PriceComRes>? = listOf(),
    @SerializedName("resourceURI")
    val resourceURI: String? = "",
    @SerializedName("series")
    val series: SeriesComRes? = SeriesComRes(),
    @SerializedName("stories")
    val stories: StoriesComRes? = StoriesComRes(),
    @SerializedName("textObjects")
    val textObjects: List<TextObjectComRes>? = listOf(),
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailComRes? = ThumbnailComRes(),
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("upc")
    val upc: String? = "",
    @SerializedName("urls")
    val urls: List<UrlComRes>? = listOf(),
    @SerializedName("variantDescription")
    val variantDescription: String? = "",
    @SerializedName("variants")
    val variants: List<VariantComRes>? = listOf()
)