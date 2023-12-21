package com.vdcast.cvs_test_task.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vdcast.cvs_test_task.data.MovieEntity
import com.vdcast.cvs_test_task.data.toMovieEntity
import com.vdcast.cvs_test_task.domain.MovieDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class AppViewModel @Inject constructor(
    private val movieDataSource: MovieDataSource
) : ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState())
    val uiState = combine(
        _uiState,
        movieDataSource.getMovies()
    ) { state, movies ->
        state.copy(
            movies = movies
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), AppUiState())


    val prefilledMoviesList = listOf(
        MovieEntity(
            title = "Tenet",
            description = "Armed with only one word, Tenet, and fighting for the survival " +
                    "of the entire world, a Protagonist journeys through a twilight " +
                    "world of international espionage on a mission that will unfold " +
                    "in something beyond real time.",
            rating = 7.8,
            duration = "2h 30 min",
            genre = "Action, Sci-Fi",
            releasedDate = "3 September 2020",
            trailerLink = "https://www.youtube.com/watch?v=LdOM0x0XDMo",
            imageName = "tenet"
        ),
        MovieEntity(
            title = "Spider-Man: Into the Spider-Verse",
            description = "Teen Miles Morales becomes the Spider-Man of his universe, " +
                    "and must join with five spider-powered individuals from other " +
                    "dimensions to stop a threat for all realities.",
            rating = 8.4,
            duration = "1h 57min",
            genre = "Action, Animation, Adventure",
            releasedDate = "14 December 2018",
            trailerLink = "https://www.youtube.com/watch?v=tg52up16eq0",
            imageName = "spider_man",
            isAddedToWatchlist = true
        ),
        MovieEntity(
            title = "Knives Out",
            description = "A detective investigates the death of a patriarch of an " +
                    "eccentric, combative family.",
            rating = 7.9,
            duration = "2h 10min",
            genre = "Comedy, Crime, Drama",
            releasedDate = "27 November 2019",
            trailerLink = "https://www.youtube.com/watch?v=qGqiHJTsRkQ",
            imageName = "knives_out",
            isAddedToWatchlist = true
        ),
        MovieEntity(
            title = "Guardians of the Galaxy",
            description = "A group of intergalactic criminals must pull together to " +
                    "stop a fanatical warrior with plans to purge the universe.",
            rating = 8.0,
            duration = "2h 1min",
            genre = "Action, Adventure, Comedy",
            releasedDate = "1 August 2014",
            trailerLink = "https://www.youtube.com/watch?v=d96cjJhvlMA",
            imageName = "guardians_of_the_galaxy"
        ),
        MovieEntity(
            title = "Avengers: Age of Ultron",
            description = "When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it\'s up to Earth\'s mightiest heroes to stop the villainous Ultron from enacting his terrible plan.",
            rating = 7.3,
            duration = "2h 21min",
            genre = "Action, Adventure, Sci-Fi",
            releasedDate = "1 May 2015",
            trailerLink = "https://www.youtube.com/watch?v=tmeOjFno6Do",
            imageName = "avengers"
        ),
    )

    init {
        prefillBalls()
    }

    private fun prefillBalls() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val currentMovies = movieDataSource.getMovies().firstOrNull()
                if (currentMovies.isNullOrEmpty()) {
                    prefilledMoviesList.forEach {
                        movieDataSource.insert(it)
                    }
                }
            }
        }
    }

    fun sortByTitle() {
        _uiState.update {
            it.copy(
                sortingCriteria = SortingCriteria.BY_TITLE
            )
        }
    }

    fun onEvent(event: MovieEvent) {
        when (event) {
            MovieEvent.SortMoviesByTitle -> {
                _uiState.update {
                    it.copy(
                        sortingCriteria = SortingCriteria.BY_TITLE
                    )
                }
            }

            MovieEvent.SortMoviesByReleaseDate -> {
                _uiState.update {
                    it.copy(
                        sortingCriteria = SortingCriteria.BY_RELEASE_DATE
                    )
                }
            }


            is MovieEvent.RemoveMovieToWatchList -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val updatedMovie = event.movie.copy(isAddedToWatchlist = false)
                    movieDataSource.update(updatedMovie.toMovieEntity())
                    _uiState.update { it.copy(
                        selectedMovie = updatedMovie,
                    ) }
                }
            }

            is MovieEvent.AddMovieToWatchList -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val updatedMovie = event.movie.copy(isAddedToWatchlist = true)
                    movieDataSource.update(updatedMovie.toMovieEntity())
                    _uiState.update { it.copy(
                        selectedMovie = updatedMovie,
                    ) }
                }
            }

            is MovieEvent.SelectMovie -> {
                _uiState.update {
                    it.copy(
                        selectedMovie = event.movie,
                    )
                }
                event.navigate()
            }

            is MovieEvent.DismissMovie -> {
                event.navigate()
            }

            MovieEvent.OnSortClicked -> {
                _uiState.update { it.copy(
                    isSortedMenuOpen = true
                ) }
            }

            MovieEvent.DismissSortedMenu -> {
                _uiState.update { it.copy(
                    isSortedMenuOpen = false
                ) }
            }
        }
    }

}