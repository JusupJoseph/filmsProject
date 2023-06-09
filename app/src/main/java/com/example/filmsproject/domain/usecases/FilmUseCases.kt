package com.example.filmsproject.domain.usecases

import com.example.filmsproject.domain.repositories.FilmRepository
import javax.inject.Inject

class FilmUseCase @Inject constructor(
    private val filmRepository: FilmRepository
) {

    operator fun invoke() = filmRepository.getFilm()
}