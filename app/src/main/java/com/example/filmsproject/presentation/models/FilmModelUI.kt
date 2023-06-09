package com.example.filmsproject.presentation.models

import com.example.filmsproject.domain.models.FilmModel
import com.example.filmsproject.presentation.base.IBaseDiffModel


data class FilmModelUI(
    override val id: String,
    val title: String,
    val originalTitle: String,
    val image: String,
    val movieBanner: String,
    val description: String,
    val director: String,
    val producer: String,
    val runningTime: String,
    val releaseDate: String,
) : IBaseDiffModel<String>

fun FilmModel.toUI() = FilmModelUI(
    id,
    title,
    originalTitle,
    image,
    movieBanner,
    description,
    director,
    producer,
    runningTime,
    releaseDate,
)

fun FilmModelUI.toDomain() = FilmModel(
    id,
    title,
    originalTitle,
    image,
    movieBanner,
    description,
    director,
    producer,
    runningTime,
    releaseDate,
)