package com.example.filmsproject.data.repoeitories

import com.example.filmsproject.data.base.BaseRepository
import com.example.filmsproject.data.remote.apiservices.FilmApiService
import com.example.filmsproject.data.remote.dtos.toDomain
import com.example.filmsproject.domain.repositories.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val apiService: FilmApiService
) : BaseRepository(), FilmRepository {

    override fun getFilm() = doRequest {
        apiService.fetchFilms().body()?.map {
            it.toDomain()
        }
    }
}