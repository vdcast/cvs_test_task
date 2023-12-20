package com.vdcast.cvs_test_task.domain

import com.vdcast.cvs_test_task.data.MovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieDataSource {
    suspend fun insert(movieEntity: MovieEntity)
    suspend fun update(movieEntity: MovieEntity)
    suspend fun delete(movieEntity: MovieEntity)
    fun getMovies(): Flow<List<Movie>>
//    fun getMovies(): Flow<List<MovieEntity>>
    suspend fun getMovieById(id: Int): MovieEntity?
}