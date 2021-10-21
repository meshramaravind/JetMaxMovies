package com.arvind.jetmaxmovies.repository

import com.arvind.jetmaxmovies.webapi.ApiService
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getPopularMovies(page:Int) =
        apiService.getMostPopularTVShows(page)
}