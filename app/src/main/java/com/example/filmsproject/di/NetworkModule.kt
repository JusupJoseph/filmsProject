package com.example.filmsproject.di

import com.example.filmsproject.data.remote.RetrofitClient
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import dagger.Module

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun provideFilmApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideFilmApiService()
}