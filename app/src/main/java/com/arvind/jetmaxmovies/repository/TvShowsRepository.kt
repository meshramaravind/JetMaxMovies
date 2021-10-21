package com.arvind.jetmaxmovies.repository

import com.arvind.jetmaxmovies.dto.TvShowsDetailsDto

interface TvShowsRepository {
    suspend fun getTvShowsDetails(tvShowId: String): TvShowsDetailsDto

}