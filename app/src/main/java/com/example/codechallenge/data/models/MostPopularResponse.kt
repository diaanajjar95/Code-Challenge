package com.example.codechallenge.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MostPopularResponse(
    @field:Json(name = "copyright")
    val copyright: String?,
    @field:Json(name = "num_results")
    val numResults: Int?,
    @field:Json(name = "results")
    val results: List<Result>?,
    @field:Json(name = "status")
    val status: String?,
)

@JsonClass(generateAdapter = true)
data class Result(
    @field:Json(name = "abstract")
    val `abstract`: String?,
    @field:Json(name = "adx_keywords")
    val adxKeywords: String?,
    @field:Json(name = "asset_id")
    val assetId: Long?,
    @field:Json(name = "byline")
    val byline: String?,
    @field:Json(name = "column")
    val column: String?,
    @field:Json(name = "des_facet")
    val desFacet: List<String>?,
    @field:Json(name = "eta_id")
    val etaId: Int?,
    @field:Json(name = "geo_facet")
    val geoFacet: List<String>?,
    @field:Json(name = "id")
    val id: Long?,
    @field:Json(name = "media")
    val media: List<Media>?,
    @field:Json(name = "nytdsection")
    val nytdsection: String?,
    @field:Json(name = "org_facet")
    val orgFacet: List<String>?,
    @field:Json(name = "per_facet")
    val perFacet: List<String>?,
    @field:Json(name = "published_date")
    val publishedDate: String?,
    @field:Json(name = "section")
    val section: String?,
    @field:Json(name = "source")
    val source: String?,
    @field:Json(name = "subsection")
    val subsection: String?,
    @field:Json(name = "title")
    val title: String?,
    @field:Json(name = "type")
    val type: String?,
    @field:Json(name = "updated")
    val updated: String?,
    @field:Json(name = "uri")
    val uri: String?,
    @field:Json(name = "url")
    val url: String?,
)

@JsonClass(generateAdapter = true)
data class MediaMetadata(
    @field:Json(name = "format")
    val format: String?,
    @field:Json(name = "height")
    val height: Int?,
    @field:Json(name = "url")
    val url: String?,
    @field:Json(name = "width")
    val width: Int?,
)

@JsonClass(generateAdapter = true)
data class Media(
    @field:Json(name = "approved_for_syndication")
    val approvedForSyndication: Int?,
    @field:Json(name = "caption")
    val caption: String?,
    @field:Json(name = "copyright")
    val copyright: String?,
    @field:Json(name = "media-metadata")
    val mediaMetadata: List<MediaMetadata>?,
    @field:Json(name = "subtype")
    val subtype: String?,
    @field:Json(name = "type")
    val type: String?,
)