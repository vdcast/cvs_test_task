package com.vdcast.cvs_test_task.ui

import com.vdcast.cvs_test_task.domain.Movie

sealed interface MovieEvent {
    object SortMoviesByTitle: MovieEvent
    object SortMoviesByReleaseDate: MovieEvent
    data class AddMovieToWatchList(val movie: Movie): MovieEvent
}