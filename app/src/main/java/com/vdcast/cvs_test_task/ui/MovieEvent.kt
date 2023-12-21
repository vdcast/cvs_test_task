package com.vdcast.cvs_test_task.ui

import com.vdcast.cvs_test_task.domain.Movie

sealed interface MovieEvent {
    object SortMoviesByTitle: MovieEvent
    object SortMoviesByReleaseDate: MovieEvent
    data class AddMovieToWatchList(val movie: Movie): MovieEvent
    data class RemoveMovieToWatchList(val movie: Movie): MovieEvent
    data class SelectMovie(val movie: Movie, val navigate: () -> Unit): MovieEvent
    data class DismissMovie(val navigate: () -> Unit): MovieEvent
    object OnSortClicked : MovieEvent
    object DismissSortedMenu : MovieEvent
}