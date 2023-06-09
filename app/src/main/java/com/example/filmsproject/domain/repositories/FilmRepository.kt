package com.example.filmsproject.domain.repositories

import com.example.filmsproject.domain.common.Either
import com.example.filmsproject.domain.models.FilmModel
import kotlinx.coroutines.flow.Flow

interface FilmRepository {

    fun getFilm(): Flow<Either<String, List<FilmModel>>>
}