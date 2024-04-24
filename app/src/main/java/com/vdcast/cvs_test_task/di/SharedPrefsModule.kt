package com.vdcast.cvs_test_task.di

import android.content.Context
import com.vdcast.cvs_test_task.data.SharedPrefs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPrefsModule {

    @Singleton
    @Provides
    fun provideSharedPrefsModule(@ApplicationContext context: Context) : SharedPrefs {
        return SharedPrefs(context)
    }

}