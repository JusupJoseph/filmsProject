package com.example.filmsproject.domain.models

data class FilmModel(
    val id: String,
    val title: String,
    val originalTitle: String,
    val image: String,
    val movieBanner: String,
    val description: String,
    val director: String,
    val producer: String,
    val runningTime: String,
    val releaseDate: String,
)