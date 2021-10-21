package com.arvind.jetmaxmovies.webapi

import com.arvind.jetmaxmovies.dto.TvShowsDetailsDto
import com.arvind.jetmaxmovies.model.DataModelMoviesPopularBase
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("most-popular")
    suspend fun getMostPopularTVShows(
        @Query("page") page: Int
    ): Response<DataModelMoviesPopularBase>

    @GET("show-details")
    suspend fun getTVShowDetails(
        @Query("q") tvShowId: String?
    ): TvShowsDetailsDto
}