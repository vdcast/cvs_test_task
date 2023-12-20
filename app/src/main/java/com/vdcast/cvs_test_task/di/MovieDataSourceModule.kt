package com.vdcast.cvs_test_task.di

import android.content.Context
import androidx.room.Room
import com.vdcast.cvs_test_task.data.AppDatabase
import com.vdcast.cvs_test_task.data.MovieDao
import com.vdcast.cvs_test_task.data.RoomMovieDataSource
import com.vdcast.cvs_test_task.domain.MovieDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalRoomModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(database: AppDatabase): MovieDao = database.movieDao()



    @Singleton
    @Provides
    fun provideRepository(
        movieDao: MovieDao,
    ): MovieDataSource = RoomMovieDataSource(movieDao)

}