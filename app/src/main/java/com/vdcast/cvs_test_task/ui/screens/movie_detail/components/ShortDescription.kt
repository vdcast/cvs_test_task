package com.vdcast.cvs_test_task.ui.screens.movie_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.vdcast.cvs_test_task.R
import com.vdcast.cvs_test_task.domain.Movie

@Composable
fun ShortDescription(
    selectedMovie: Movie?
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_m_l)))
        Text(
            text = stringResource(id = R.string.short_description),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
        Text(
            text = selectedMovie?.description ?: "-",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_m_l)))
    }
}