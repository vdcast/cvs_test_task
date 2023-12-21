package com.vdcast.cvs_test_task.data

import com.vdcast.cvs_test_task.domain.Movie
import com.vdcast.cvs_test_task.domain.MovieDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomMovieDataSource(private val movieDao: MovieDao) : MovieDataSource {
    override suspend fun insert(movieEntity: MovieEntity) = movieDao.insert(movieEntity)
    override suspend fun update(movieEntity: MovieEntity) = movieDao.update(movieEntity)
    override suspend fun delete(movieEntity: MovieEntity) = movieDao.delete(movieEntity)
    override fun getMovies(): Flow<List<Movie>> = movieDao.getMovies()
        .map { movieEntities ->
            movieEntities.map { it.toMovie() }
        }
    override suspend fun getMovieById(id: Int): MovieEntity? = movieDao.getMovieById(id)
}