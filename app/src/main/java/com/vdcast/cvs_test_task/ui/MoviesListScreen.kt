package com.vdcast.cvs_test_task.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.vdcast.cvs_test_task.R
import com.vdcast.cvs_test_task.ui.components.MoviesListItem
import com.vdcast.cvs_test_task.ui.components.MoviesRow
import com.vdcast.cvs_test_task.ui.components.SortRow

@Composable
fun MoviesListScreen(
    appViewModel: AppViewModel,
    uiState: AppUiState,
    onEvent: (MovieEvent) -> Unit,
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
        SortRow()
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
        MoviesRow()

        uiState.sortedMovies.forEach { movie ->
            MoviesListItem(
                context = context,
                movie = movie
            )
        }
    }
}