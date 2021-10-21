package com.arvind.jetmaxmovies.usecase

import android.util.Log
import com.arvind.jetmaxmovies.dto.TvShowDetails
import com.arvind.jetmaxmovies.dto.toTvShowDetail
import com.arvind.jetmaxmovies.model.TvShowsResponse
import com.arvind.jetmaxmovies.repository.TvShowsRepository
import com.arvind.jetmaxmovies.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTvShowsDetailsUseCase @Inject constructor(
    private val repository: TvShowsRepository
) {
    operator fun invoke(tvShowId: String): Flow<Resource<TvShowDetails>> = flow {
        try {
            emit(Resource.Loading<TvShowDetails>())
            val tvShow = repository.getTvShowsDetails(tvShowId).toTvShowDetail()
            Log.e("tv", tvShowId)
            emit(Resource.Success<TvShowDetails>(tvShow))
        } catch (e: HttpException) {
            emit(Resource.Error<TvShowDetails>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<TvShowDetails>("Couldn't reach server. Check your internet connection."))
        }
    }
}