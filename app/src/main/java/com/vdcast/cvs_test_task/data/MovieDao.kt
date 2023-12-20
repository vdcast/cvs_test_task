package com.vdcast.cvs_test_task.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movieEntity: MovieEntity)
    @Update
    suspend fun update(movieEntity: MovieEntity)
    @Delete
    suspend fun delete(movieEntity: MovieEntity)
    @Query("SELECT * FROM movies_table ORDER BY id ASC")
    fun getMovies(): Flow<List<MovieEntity>>
    @Query("SELECT * FROM movies_table WHERE id = :id")
    suspend fun getMovieById(id: Int): MovieEntity?
}