package com.vdcast.cvs_test_task.ui

import android.util.Log
import com.vdcast.cvs_test_task.domain.Movie
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class AppUiState(
    val movies: List<Movie> = emptyList(),
    val selectedMovie: Movie? = null,
    val sortingCriteria: SortingCriteria = SortingCriteria.NOT_SORTED,
    val isSortedMenuOpen: Boolean = false,
    val isMoviesLoaded: Boolean = false,
) {
    val sortedMovies: List<Movie>
        get() = when (sortingCriteria) {
            SortingCriteria.BY_TITLE -> movies.sortedBy { it.title }
            SortingCriteria.BY_RELEASE_DATE -> movies.sortedBy { parseDate(it.releasedDate) }
            else -> movies
        }
}

enum class SortingCriteria {
    NOT_SORTED,
    BY_TITLE,
    BY_RELEASE_DATE
}

private fun parseDate(dateString: String): Date? {
    val format = SimpleDateFormat("d MMMM yyyy", Locale.ENGLISH)
    return try {
        format.parse(dateString)
    } catch (e: Exception) {
        Log.d("MYLOG", "Wrong date! It can't be parse.")
        null
    }
}