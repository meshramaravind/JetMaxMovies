package com.arvind.jetmaxmovies.model

import com.google.gson.annotations.SerializedName


data class ResponseTvShowsDetails(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("permalink") val permalink: String,
    @SerializedName("url") val url: String,
    @SerializedName("description") val description: String,
    @SerializedName("description_source") val description_source: String,
    @SerializedName("start_date") val start_date: String,
    @SerializedName("end_date") val end_date: String,
    @SerializedName("country") val country: String,
    @SerializedName("status") val status: String,
    @SerializedName("runtime") val runtime: Int,
    @SerializedName("network") val network: String,
    @SerializedName("youtube_link") val youtube_link: String,
    @SerializedName("image_path") val image_path: String,
    @SerializedName("image_thumbnail_path") val image_thumbnail_path: String,
    @SerializedName("rating") val rating: Double,
    @SerializedName("rating_count") val rating_count: Int,
    @SerializedName("countdown") val countdown: String,
    @SerializedName("genres") val genres: List<String>,
    @SerializedName("pictures") val pictures: List<String>,
    @SerializedName("episodes") val episodes: List<Episodes>
)
data class Episodes (

    @SerializedName("season") val season : Int,
    @SerializedName("episode") val episode : Int,
    @SerializedName("name") val name : String,
    @SerializedName("air_date") val air_date : String
)
