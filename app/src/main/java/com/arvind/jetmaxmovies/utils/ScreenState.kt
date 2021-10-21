package com.arvind.jetmaxmovies.utils

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.arvind.jetmaxmovies.R
import com.arvind.jetmaxmovies.ui.theme.JetMaxMoviesTheme


@Composable
fun LoadingView(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun LoadingItem() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}

@Composable
fun ErrorItem(
    message: String,
    modifier: Modifier = Modifier,
    onClickRetry: () -> Unit,
) {
    Row(
        modifier = modifier.padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = message,
            maxLines = 1,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.h6,
            color = Color.Red
        )
        OutlinedButton(onClick = onClickRetry) {
            Text(text = stringResource(id = R.string.text_try_again))
        }
    }
}

@Preview("Loading View")
@Composable
private fun LoadingViewPreview() {
    JetMaxMoviesTheme {
        LoadingView(
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Preview("Loading View • Dark")
@Composable
private fun LoadingViewDarkPreview() {
    JetMaxMoviesTheme(darkTheme = true) {
        LoadingView(
            modifier = Modifier.fillMaxWidth()
        )
    }
}
