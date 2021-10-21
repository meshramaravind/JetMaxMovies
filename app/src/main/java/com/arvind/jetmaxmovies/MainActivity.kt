package com.arvind.jetmaxmovies

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.arvind.jetmaxmovies.navigation.Navigation
import com.arvind.jetmaxmovies.ui.theme.JetMaxMoviesTheme
import com.arvind.jetmaxmovies.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    @RequiresApi(Build.VERSION_CODES.N)
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<MainViewModel>()
            JetMaxMoviesMain(viewModel)
        }
    }

    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    @RequiresApi(Build.VERSION_CODES.N)
    @Composable
    fun JetMaxMoviesMain(viewModel: MainViewModel) {
        JetMaxMoviesTheme() {
            // A surface container using the 'background' color from the theme
            Surface(color = MaterialTheme.colors.background) {
                Navigation(viewModel)
            }
        }
    }
}

