package com.vdcast.cvs_test_task.ui.screens.main_movies

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.vdcast.cvs_test_task.R
import com.vdcast.cvs_test_task.ui.AppUiState
import com.vdcast.cvs_test_task.ui.MovieEvent
import com.vdcast.cvs_test_task.ui.screens.main_movies.components.MoviesListItem
import com.vdcast.cvs_test_task.ui.screens.main_movies.components.MoviesRow
import com.vdcast.cvs_test_task.ui.screens.main_movies.components.SortRow

@Composable
fun MainMoviesScreen(
    uiState: AppUiState,
    onEvent: (MovieEvent) -> Unit,
    navigateToDetailsScreen: () -> Unit,
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = dimensionResource(id = R.dimen.padding_m_l),
                end = dimensionResource(id = R.dimen.padding_medium),
            )
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
        SortRow(
            modifier = Modifier.clickable {
                onEvent(MovieEvent.OnSortClicked)
            }
        ) {
            DropdownMenu(
                expanded = uiState.isSortedMenuOpen,
                onDismissRequest = {
                    onEvent(MovieEvent.DismissSortedMenu)
                })
            {
                DropdownMenuItem(
                    text = { Text(text = stringResource(id = R.string.by_title)) },
                    onClick = {
                        onEvent(MovieEvent.SortMoviesByTitle)
                        onEvent(MovieEvent.DismissSortedMenu)
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(id = R.string.by_released_date)) },
                    onClick = {
                        onEvent(MovieEvent.SortMoviesByReleaseDate)
                        onEvent(MovieEvent.DismissSortedMenu)
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_xsmall)))
        MoviesRow()
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
        uiState.sortedMovies.forEach { movie ->
            MoviesListItem(
                context = context,
                movie = movie,
                modifier = Modifier.clickable {
                    onEvent(MovieEvent.SelectMovie(movie) {
                        navigateToDetailsScreen()
                    })
                }
            )
        }
    }
}