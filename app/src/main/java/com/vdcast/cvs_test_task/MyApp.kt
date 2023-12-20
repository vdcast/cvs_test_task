package com.vdcast.cvs_test_task

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.vdcast.cvs_test_task.ui.AppViewModel
import com.vdcast.cvs_test_task.ui.MoviesListScreen
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {

}

@Composable
fun AppUi(
    appViewModel: AppViewModel = hiltViewModel()
) {
    val uiState by appViewModel.uiState.collectAsState()
    MoviesListScreen(
        appViewModel = appViewModel,
        uiState = uiState,
        onEvent = appViewModel::onEvent
    )
}