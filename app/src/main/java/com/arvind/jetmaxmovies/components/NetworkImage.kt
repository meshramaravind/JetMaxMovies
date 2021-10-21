package com.arvind.jetmaxmovies.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter

@Composable
fun NetworkImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    fadeIn: Boolean = true,
    @DrawableRes previewPlaceholder: Int = 0
) {

    Image(
        painter = rememberImagePainter(
            data = imageUrl,
            onExecute = ImagePainter.ExecuteCallback { _, _ -> true },
        ),
        contentDescription = null,
        modifier = Modifier.size(50.dp)
    )

}