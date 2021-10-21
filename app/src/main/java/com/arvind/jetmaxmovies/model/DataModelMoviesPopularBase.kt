package com.arvind.jetmaxmovies.model

import com.google.gson.annotations.SerializedName

data class DataModelMoviesPopularBase(
    @SerializedName("total") val total: Int,
    @SerializedName("page") val page: Int,
    @SerializedName("pages") val pages: Int,
    @SerializedName("tv_shows") val tv_shows: List<TvShowsResponse>
)

data class TvShowsResponse(

    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("permalink") val permalink: String,
    @SerializedName("start_date") val start_date: String,
    @SerializedName("end_date") val end_date: String,
    @SerializedName("country") val country: String,
    @SerializedName("network") val network: String,
    @SerializedName("status") val status: String,
    @SerializedName("image_thumbnail_path") val image_thumbnail_path: String
)
