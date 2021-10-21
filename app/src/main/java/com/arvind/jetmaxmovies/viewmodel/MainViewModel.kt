package com.arvind.jetmaxmovies.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.arvind.jetmaxmovies.model.TvShowsResponse
import com.arvind.jetmaxmovies.paging.PopularMoviesPagingSource
import com.arvind.jetmaxmovies.repository.MoviesRepository
import com.arvind.jetmaxmovies.state.TvShowDetailsState
import com.arvind.jetmaxmovies.usecase.GetTvShowsDetailsUseCase
import com.arvind.jetmaxmovies.utils.Constants
import com.arvind.jetmaxmovies.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    moviesRepository: MoviesRepository,
    private val getTvShowsDetailsUseCase: GetTvShowsDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val popularMovies: Flow<PagingData<TvShowsResponse>> =
        Pager(PagingConfig(pageSize = 10)) {
            PopularMoviesPagingSource(moviesRepository)
        }.flow

    private val _state = mutableStateOf(TvShowDetailsState())
    val state: State<TvShowDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_TV_SHOW_ID)?.let { tvShowId ->
            Log.e("tv", tvShowId)
            getTvShowDetails(tvShowId)
        }
    }

    private fun getTvShowDetails(tvShowId: String) {
        getTvShowsDetailsUseCase(tvShowId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = TvShowDetailsState(tvShow = result.data)

                }
                is Resource.Error -> {
                    _state.value = TvShowDetailsState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = TvShowDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}