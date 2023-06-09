package com.example.filmsproject.di

import com.example.filmsproject.data.repoeitories.FilmRepositoryImpl
import com.example.filmsproject.domain.repositories.FilmRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindFilmRepository(filmRepositoryImpl: FilmRepositoryImpl): FilmRepository
}