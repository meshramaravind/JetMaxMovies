package com.arvind.jetmaxmovies.view

import android.content.res.Configuration
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.arvind.jetmaxmovies.R
import com.arvind.jetmaxmovies.navigation.Screen
import com.arvind.jetmaxmovies.ui.theme.JetMaxMoviesTheme
import com.arvind.jetmaxmovies.utils.Constants
import com.arvind.jetmaxmovies.utils.LoadingView
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@Composable
fun SplashScreen(
    navController: NavController,
    dispatcher: CoroutineDispatcher = Dispatchers.Main
) {
    val scale = remember {
        Animatable(0f)
    }
    val overshootInterpolator = remember {
        OvershootInterpolator(2f)
    }
    LaunchedEffect(key1 = true) {
        withContext(dispatcher) {
            scale.animateTo(
                targetValue = 0.5f,
                animationSpec = tween(
                    durationMillis = 500,
                    easing = {
                        overshootInterpolator.getInterpolation(it)
                    }
                )
            )
            delay(Constants.SPLASH_SCREEN_DURATION)
            navController.popBackStack()
            navController.navigate(Screen.MoviesHomeScreen.route)
        }
    }

    Box(
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
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_play_circle_filled_24),
                contentDescription = "Logo",
                modifier = Modifier.size(128.dp)
            )

            Text(
                text = "MaxMovie",
                style = MaterialTheme.typography.h5,

                )
        }
    }
}

@Preview("Splash Screen")
@Composable
private fun SplashScreenPreview() {
    JetMaxMoviesTheme {
        SplashScreen(
            navController = NavController(LocalContext.current),

            )
    }
}


@Preview("Splash Screen • Dark")
@Composable
private fun SplashScreenDarkPreview() {
    JetMaxMoviesTheme(darkTheme = true) {
        SplashScreen(
            navController = NavController(LocalContext.current),

            )
    }
}

