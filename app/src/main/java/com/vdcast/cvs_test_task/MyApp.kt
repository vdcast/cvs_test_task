package com.vdcast.cvs_test_task

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vdcast.cvs_test_task.ui.AppViewModel
import com.vdcast.cvs_test_task.ui.screens.MainMoviesScreen
import com.vdcast.cvs_test_task.ui.screens.MovieDetailScreen
import com.vdcast.cvs_test_task.ui.navigation.Routes
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {

}

@Composable
fun AppUi(
    appViewModel: AppViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController(),
) {
    val uiState by appViewModel.uiState.collectAsState()


    NavHost(
        navController = navController,
        startDestination = Routes.MainMoviesScreen.route,
    ) {
        composable(Routes.MainMoviesScreen.route) {
            MainMoviesScreen(
                uiState = uiState,
                onEvent = appViewModel::onEvent,
                navigateToDetailsScreen = {
                    navController.navigate(Routes.MovieDetailScreen.route)
                }
            )
        }
        composable(Routes.MovieDetailScreen.route) {
            MovieDetailScreen(
//                isOpen = uiState.isSelectedMovieDetailOpen,
                selectedMovie = uiState.selectedMovie,
                onEvent = appViewModel::onEvent,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}