package com.arvind.jetmaxmovies.view

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.arvind.jetmaxmovies.ui.theme.JetMaxMoviesTheme
import com.arvind.jetmaxmovies.viewmodel.MainViewModel

@Composable
fun TvShowsDetailsScreen(
    viewModel: MainViewModel
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        Log.e("tvShowDetails","tvShowDetails")
        state.tvShow?.let { tvShowDetails ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = tvShowDetails.tvShow.name,
                            style = MaterialTheme.typography.body2
                        )
                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = tvShowDetails.tvShow.country,
                            style = MaterialTheme.typography.body2
                        )
                    }

                }

            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Preview("Tv Shows Details Screen")
@Composable
private fun TvShowsDetailsScreenPreview() {
    JetMaxMoviesTheme {
        TvShowsDetailsScreen(
            viewModel(),

            )
    }
}


@Preview("Tv Shows Details Screen • Dark")
@Composable
private fun TvShowsDetailsScreenDarkPreview() {
    JetMaxMoviesTheme(darkTheme = true) {
        TvShowsDetailsScreen(
            viewModel(),
        )
    }
}