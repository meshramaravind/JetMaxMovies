package com.arvind.jetmaxmovies.repository

import android.util.Log
import com.arvind.jetmaxmovies.dto.TvShowsDetailsDto
import com.arvind.jetmaxmovies.webapi.ApiService
import javax.inject.Inject

class TvShowsDetailsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : TvShowsRepository {
    override suspend fun getTvShowsDetails(tvShowId: String): TvShowsDetailsDto {
        Log.e("tv", tvShowId)
        return apiService.getTVShowDetails(tvShowId)
    }
}