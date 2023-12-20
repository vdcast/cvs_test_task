package com.vdcast.cvs_test_task.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.vdcast.cvs_test_task.R

@Composable
fun SortRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            modifier = Modifier
                .padding(end = dimensionResource(id = R.dimen.padding_small)),
            text = stringResource(id = R.string.sort),
            style = MaterialTheme.typography.titleMedium
        )
    }
}