package com.arvind.jetmaxmovies.paging

import androidx.compose.runtime.mutableStateListOf
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.arvind.jetmaxmovies.model.TvShowsResponse
import com.arvind.jetmaxmovies.repository.MoviesRepository
import com.arvind.jetmaxmovies.utils.Constants.STARTING_PAGE_INDEX
import retrofit2.HttpException
import java.io.IOException

class PopularMoviesPagingSource(
    private val moviesRepository: MoviesRepository,
) : PagingSource<Int, TvShowsResponse>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShowsResponse> {
        return try {
            val nextPageNumber = params.key ?: STARTING_PAGE_INDEX
            val response = moviesRepository.getPopularMovies(
                nextPageNumber
            )
            val responseData = mutableStateListOf<TvShowsResponse>()
            val data = response.body()?.tv_shows ?: emptyList()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (nextPageNumber > 0) nextPageNumber - 1 else null,
                nextKey = if (nextPageNumber < response.body()?.pages!!) nextPageNumber + 1 else null
            )
        } catch (exception: IOException) {
            val error = IOException("Please Check Internet Connection")
            LoadResult.Error(error)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, TvShowsResponse>): Int? {
        return null
    }
}