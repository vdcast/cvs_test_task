package com.vdcast.cvs_test_task.ui.navigation

sealed class Routes(val route: String) {
    object MainMoviesScreen : Routes("MainMoviesScreen")
    object MovieDetailScreen : Routes("MovieDetailScreen")
}
