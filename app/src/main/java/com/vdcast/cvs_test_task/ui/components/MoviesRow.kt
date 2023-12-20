package com.vdcast.cvs_test_task.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.vdcast.cvs_test_task.R

@Composable
fun MoviesRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = stringResource(id = R.string.movies),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )
    }
}