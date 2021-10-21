package com.arvind.jetmaxmovies.dto

import com.arvind.jetmaxmovies.model.Episodes
import com.arvind.jetmaxmovies.model.ResponseTvShowsDetails
import com.google.gson.annotations.SerializedName

data class TvShowsDetailsDto(
    @SerializedName("tvShow") val tvShow: ResponseTvShowsDetails
)

fun TvShowsDetailsDto.toTvShowDetail(): TvShowDetails {
    return TvShowDetails(
        tvShow = ResponseTvShowsDetails(
            id = tvShow.id,
            name = tvShow.name,
            permalink = tvShow.permalink,
            url = tvShow.url,
            description = tvShow.description,
            description_source = tvShow.description_source,
            start_date = tvShow.start_date,
            end_date = tvShow.end_date,
            country = tvShow.country,
            status = tvShow.status,
            runtime = tvShow.runtime,
            network = tvShow.network,
            youtube_link = tvShow.youtube_link,
            image_path = tvShow.image_path,
            image_thumbnail_path = tvShow.image_thumbnail_path,
            rating_count = tvShow.rating_count,
            countdown = tvShow.countdown,
            rating = tvShow.rating,
            genres = tvShow.genres,
            pictures = tvShow.pictures,
            episodes = tvShow.episodes

        )
    )
}