package com.vdcast.cvs_test_task.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies_table")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val rating: Double = 0.0,
    val duration: String = "",
    val genre: String = "",
    val releasedDate: String = "",
    val trailerLink: String = "",
    val imageName: String = "",
    val addedToWatchlist: Boolean = false,
)
