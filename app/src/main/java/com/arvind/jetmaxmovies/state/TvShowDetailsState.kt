package com.arvind.jetmaxmovies.state

import com.arvind.jetmaxmovies.dto.TvShowDetails

data class TvShowDetailsState(
    val isLoading: Boolean = false,
    val tvShow: TvShowDetails? = null,
    val error: String = ""
)
