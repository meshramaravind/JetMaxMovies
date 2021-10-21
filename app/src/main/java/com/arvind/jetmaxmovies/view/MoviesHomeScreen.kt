package com.arvind.jetmaxmovies.view

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.arvind.jetmaxmovies.components.PopularMoviesItems
import com.arvind.jetmaxmovies.model.TvShowsResponse
import com.arvind.jetmaxmovies.navigation.Screen
import com.arvind.jetmaxmovies.ui.theme.JetMaxMoviesTheme
import com.arvind.jetmaxmovies.utils.ErrorItem
import com.arvind.jetmaxmovies.utils.LoadingItem
import com.arvind.jetmaxmovies.utils.LoadingView
import com.arvind.jetmaxmovies.viewmodel.MainViewModel
import kotlinx.coroutines.flow.Flow

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun MoviesHomeScreen(
    viewModel: MainViewModel,
    navController: NavController
) {
    Scaffold(topBar = {
        TopAppBar(
            modifier = Modifier.background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF966DE7),
                        Color(0xFF755CD4),
                        Color(0xFF4C48C1)
                    )
                )
            ),
            title = {
                Text(
                    text = "Max Movies",
                    style = MaterialTheme.typography.body1,
                    color = Color.White
                )
            },
            backgroundColor = Color.Transparent,
            elevation = 0.dp
        )
    },
        content = {
            MainContent(
                popularMovies = viewModel.popularMovies,
                navController
            )
        })
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun MainContent(
    popularMovies:
    Flow<PagingData<TvShowsResponse>>,
    navController: NavController
) {
    val lazyPopularMoviesItems = popularMovies.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF966DE7),
                        Color(0xFF755CD4),
                        Color(0xFF4C48C1)
                    )
                )
            )
    ) {
        item {
            Spacer(modifier = Modifier.height(10.dp))
        }
        items(lazyPopularMoviesItems) { tvShowsResponseItem ->
            PopularMoviesItems(
                tvShowsResponse = tvShowsResponseItem!!,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                onItemClick = {
                    navController.navigate(Screen.MoviesDetailsScreen.route + "/${tvShowsResponseItem.id}")

                }
            )

        }

        lazyPopularMoviesItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { LoadingView(modifier = Modifier.fillParentMaxSize()) }
                }
                loadState.append is LoadState.Loading -> {
                    item { LoadingItem() }
                }
                loadState.refresh is LoadState.Error -> {
                    val e = lazyPopularMoviesItems.loadState.refresh as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage!!,
                            modifier = Modifier.fillParentMaxSize(),
                            onClickRetry = { retry() }
                        )
                    }
                }
                loadState.append is LoadState.Error -> {
                    val e = lazyPopularMoviesItems.loadState.append as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage!!,
                            onClickRetry = { retry() }
                        )
                    }
                }
            }
        }
    }
}


@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    JetMaxMoviesTheme {
        MoviesHomeScreen(
            viewModel(),
            navController = NavController(LocalContext.current),
        )
    }
}
