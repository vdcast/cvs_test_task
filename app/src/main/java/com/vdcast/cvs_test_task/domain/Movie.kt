package com.vdcast.cvs_test_task.domain

data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val rating: Double,
    val duration: String,
    val genre: String,
    val releasedDate: String,
    val trailerLink: String,
    val imageName: String,
    val addedToWatchlist: Boolean,
)