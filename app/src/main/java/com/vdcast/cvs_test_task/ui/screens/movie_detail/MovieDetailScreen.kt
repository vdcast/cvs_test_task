package com.vdcast.cvs_test_task.ui.screens.movie_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.vdcast.cvs_test_task.R
import com.vdcast.cvs_test_task.domain.Movie
import com.vdcast.cvs_test_task.ui.MovieEvent
import com.vdcast.cvs_test_task.ui.screens.movie_detail.components.BottomDetails
import com.vdcast.cvs_test_task.ui.screens.movie_detail.components.RowWithImageAndButtons
import com.vdcast.cvs_test_task.ui.screens.movie_detail.components.ShortDescription
import com.vdcast.cvs_test_task.ui.screens.movie_detail.components.TopBarMovieDetail

@Composable
fun MovieDetailScreen(
    selectedMovie: Movie?,
    onEvent: (MovieEvent) -> Unit,
    onBack: () -> Unit,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
        TopBarMovieDetail(
            modifier = Modifier
                .clickable {
                    onEvent(MovieEvent.DismissMovie {
                        onBack()
                    })
                }
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
        Divider(modifier = Modifier.height(dimensionResource(id = R.dimen.thickness_divider)))
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_m_l)))
        Column(
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
        ) {
            RowWithImageAndButtons(
                selectedMovie = selectedMovie,
                onEvent = onEvent
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_m_l)))
            Divider(modifier = Modifier.height(dimensionResource(id = R.dimen.thickness_divider)))
            ShortDescription(selectedMovie = selectedMovie)
            Divider(modifier = Modifier.height(dimensionResource(id = R.dimen.thickness_divider)))
            BottomDetails(selectedMovie = selectedMovie)
        }
    }


}