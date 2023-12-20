package com.vdcast.cvs_test_task.data

import com.vdcast.cvs_test_task.domain.Movie

fun MovieEntity.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        description = description,
        rating = rating,
        duration = duration,
        genre = genre,
        releasedDate = releasedDate,
        trailerLink = trailerLink,
        imageName = imageName,
        isAddedToWatchlist = isAddedToWatchlist,
    )
}
fun Movie.toMovieEntity(): MovieEntity {
    return MovieEntity(
        id = id,
        title = title,
        description = description,
        rating = rating,
        duration = duration,
        genre = genre,
        releasedDate = releasedDate,
        trailerLink = trailerLink,
        imageName = imageName,
        isAddedToWatchlist = isAddedToWatchlist,
    )
}