package com.vdcast.cvs_test_task.ui.screens.movie_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.vdcast.cvs_test_task.R

@Composable
fun TopBarMovieDetail(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.padding_xlarge)),
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = "arrow left-back"
        )
        Text(
            text = stringResource(id = R.string.movies),
            style = MaterialTheme.typography.titleMedium
        )
    }
}