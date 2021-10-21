package com.arvind.jetmaxmovies.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arvind.jetmaxmovies.R
import com.arvind.jetmaxmovies.model.TvShowsResponse
import com.arvind.jetmaxmovies.ui.theme.ColorCardBackgroundNight
import com.arvind.jetmaxmovies.ui.theme.ColorTextPrimary
import com.arvind.jetmaxmovies.ui.theme.JetMaxMoviesTheme
import com.google.accompanist.coil.rememberCoilPainter

@ExperimentalMaterialApi
@Composable
fun PopularMoviesItems(
    tvShowsResponse: TvShowsResponse,
    modifier: Modifier = Modifier,
    onItemClick: (TvShowsResponse) -> Unit
) {
    Spacer(modifier = Modifier.height(44.dp))
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()

    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(8.dp),
            backgroundColor = ColorCardBackgroundNight,
            onClick = {onItemClick(tvShowsResponse)},
            shape = RoundedCornerShape(8.dp),

        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .weight(0.4f)
                ) {

                }
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                    modifier = modifier
                        .fillMaxWidth()
                        .weight(0.6f)
                ) {
                    Text(
                        text = tvShowsResponse.name,
                        style = MaterialTheme.typography.subtitle1,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = "Network:",
                            fontSize = 12.sp,
                            color = ColorTextPrimary
                        )
                        Text(
                            text = tvShowsResponse.network,
                            fontSize = 12.sp,
                            color = ColorTextPrimary,
                            modifier = Modifier.padding(horizontal = 5.dp)
                        )

                    }

                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = "Date:",
                            fontSize = 12.sp,
                            color = ColorTextPrimary
                        )
                        Text(
                            text = tvShowsResponse.start_date,
                            fontSize = 12.sp,
                            color = ColorTextPrimary,
                            modifier = Modifier.padding(horizontal = 5.dp)
                        )

                    }

                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = "Status:",
                            fontSize = 12.sp,
                            color = ColorTextPrimary
                        )
                        Text(
                            text = tvShowsResponse.status,
                            color = ColorTextPrimary,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(horizontal = 5.dp)
                        )
                    }


                }
            }
        }
        Card(
            modifier = Modifier
                .offset(16.dp, (-44).dp)
                .fillMaxWidth(0.3f)
                .height(164.dp),
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.DarkGray
        ) {
            val image = rememberCoilPainter(
                request = tvShowsResponse.image_thumbnail_path,
                fadeIn = true,
                previewPlaceholder = R.drawable.placeholder,
            )

            Image(
                painter = image,
                contentDescription = "Popular Tv Show Image",
                contentScale = ContentScale.Crop,
            )

        }
    }


}

@ExperimentalMaterialApi
@Preview("Popular Movies Items")
@Composable
private fun PopularMoviesItemsPreview() {
    JetMaxMoviesTheme {
        PopularMoviesItems(
            tvShowsResponse = TvShowsResponse(
                id = "29560",
                name = "The Flash",
                permalink = "the-flash",
                start_date = "2014-10-07",
                end_date = "",
                country = "US",
                network = "The CW",
                status = "Running",
                image_thumbnail_path = "https://static.episodate.com/images/tv-show/thumbnail/35624.jpg"
            ),
            modifier = Modifier.fillMaxWidth()

        ) {}
    }
}


@ExperimentalMaterialApi
@Preview("Popular Movies Items • Dark")
@Composable
private fun PopularMoviesItemsDarkPreview() {
    JetMaxMoviesTheme(darkTheme = true) {
        PopularMoviesItems(
            tvShowsResponse = TvShowsResponse(
                id = "29560",
                name = "The Flash",
                permalink = "the-flash",
                start_date = "2014-10-07",
                end_date = "",
                country = "US",
                network = "The CW",
                status = "Running",
                image_thumbnail_path = "https://static.episodate.com/images/tv-show/thumbnail/35624.jpg"
            ),
            modifier = Modifier.fillMaxWidth()

        ) {}
    }
}