package com.vdcast.cvs_test_task.ui.screens.movie_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
fun BottomDetails(
    selectedMovie: Movie?
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_m_l)))
        Text(
            text = stringResource(id = R.string.details),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
        Row {
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = stringResource(id = R.string.genre),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(id = R.string.released_date),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_s_m)))
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = selectedMovie?.genre ?: "-",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
                Text(
                    text = selectedMovie?.releasedDate ?: "-",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        }
    }
}