package com.vdcast.cvs_test_task.ui.screens.main_movies.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.vdcast.cvs_test_task.R
import com.vdcast.cvs_test_task.domain.Movie

@Composable
fun MoviesListItem(
    context: Context,
    movie: Movie,
    modifier: Modifier = Modifier
) {
    val imageId = context.resources.getIdentifier(
        movie.imageName,
        "drawable",
        context.packageName
    )

    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Card(
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_xsmall)),
            elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.padding_small))
        ) {
            Image(
                modifier = Modifier
                    .heightIn(max = dimensionResource(id = R.dimen.padding_xxxxlarge))
                    .aspectRatio(950f / 1400f),
                painter = painterResource(id = imageId),
                contentDescription = movie.title
            )
        }
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_m_l)))
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "${movie.title} (${movie.releasedDate.takeLast(4)})", // TODO add handling, if last 4 chars aren't year
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_xsmall)))
            Text(
                text = "${movie.duration} - ${movie.genre}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            if (movie.isAddedToWatchlist) {
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_m_l)))
                Text(
                    text = stringResource(id = R.string.on_my_watchlist),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_m_l)))
    Divider(modifier = Modifier.height(dimensionResource(id = R.dimen.thickness_divider)))
}