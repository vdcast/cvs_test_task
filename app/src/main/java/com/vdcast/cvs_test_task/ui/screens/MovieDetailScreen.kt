package com.vdcast.cvs_test_task.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vdcast.cvs_test_task.R
import com.vdcast.cvs_test_task.domain.Movie
import com.vdcast.cvs_test_task.ui.MovieEvent

@Composable
fun MovieDetailScreen(
    selectedMovie: Movie?,
    onEvent: (MovieEvent) -> Unit,
    onBack: () -> Unit,
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val uriHandler = LocalUriHandler.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onEvent(MovieEvent.DismissMovie {
                        onBack()
                    })
                },
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
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
        Divider(modifier = Modifier.height(dimensionResource(id = R.dimen.thickness_divider)))
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_m_l)))
        Column(
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
        ) {

            val imageId = context.resources.getIdentifier(
                selectedMovie?.imageName ?: "icon_movie",
                "drawable",
                context.packageName
            )
            Row(
                modifier = Modifier
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
                            .heightIn(max = dimensionResource(id = R.dimen.padding_192))
                            .aspectRatio(950f / 1400f),
                        painter = painterResource(id = imageId),
                        contentDescription = selectedMovie?.title ?: "-"
                    )
                }
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.Start,
//                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier
                            .padding(top = dimensionResource(id = R.dimen.padding_xsmall)),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = selectedMovie?.title ?: "-",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
                        Row(
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Text(
                                text = selectedMovie?.rating.toString(),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                            )
                            Text(
                                text = "/10",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.Gray
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_m_l)))
                    selectedMovie?.let { movie ->
                        if (movie.isAddedToWatchlist) {
                            Button(
                                modifier = Modifier.fillMaxWidth(),
                                onClick = {
                                    onEvent(MovieEvent.RemoveMovieToWatchList(selectedMovie))
                                },
                                contentPadding = PaddingValues(
                                    horizontal = 8.dp,
                                    vertical = 4.dp
                                )
                            ) {
                                Text(
                                    text = stringResource(id = R.string.remove_from_watchlist),
                                    style = MaterialTheme.typography.labelSmall
                                )
                            }
                        } else {
                            Button(
                                modifier = Modifier.fillMaxWidth(),
                                onClick = {
                                    onEvent(MovieEvent.AddMovieToWatchList(selectedMovie))
                                },
                                contentPadding = PaddingValues(
                                    horizontal = 8.dp,
                                    vertical = 4.dp
                                )
                            ) {
                                Text(
                                    text = stringResource(id = R.string.add_to_watchlist),
                                    style = MaterialTheme.typography.labelSmall
                                )
                            }

                        }
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_xsmall)))
                    OutlinedButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            selectedMovie?.let { movie ->
                                uriHandler.openUri(movie.trailerLink)
                            }
                        },
                    ) {
                        Text(
                            text = stringResource(id = R.string.watch_trailer),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_m_l)))
            Divider(modifier = Modifier.height(dimensionResource(id = R.dimen.thickness_divider)))
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
            Divider(modifier = Modifier.height(dimensionResource(id = R.dimen.thickness_divider)))
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
                Row(

                ) {
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
    }
}