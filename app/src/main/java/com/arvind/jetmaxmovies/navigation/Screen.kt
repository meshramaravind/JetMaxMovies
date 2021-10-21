package com.arvind.jetmaxmovies.navigation

import android.annotation.SuppressLint

sealed class Screen(val route: String) {

    @SuppressLint("CustomSplashScreen")
    object SplashScreen : Screen("nav_splash_screen")
    object MoviesHomeScreen : Screen("nav_movies_home_screen")
    object MoviesDetailsScreen : Screen("nav_movies_details_screen")
    object EpisodeScreen : Screen("nav_episode_screen")

}

