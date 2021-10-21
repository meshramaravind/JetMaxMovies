package com.arvind.jetmaxmovies.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arvind.jetmaxmovies.view.MoviesHomeScreen
import com.arvind.jetmaxmovies.view.SplashScreen
import com.arvind.jetmaxmovies.view.TvShowsDetailsScreen
import com.arvind.jetmaxmovies.viewmodel.MainViewModel

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun Navigation(viewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.MoviesHomeScreen.route) {
            MoviesHomeScreen(viewModel,navController)
        }

        composable(Screen.MoviesDetailsScreen.route + "/{tvShowId}") {
            TvShowsDetailsScreen(viewModel)
        }


    }
}