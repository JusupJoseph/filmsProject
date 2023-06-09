package com.example.filmsproject.presentation.ui.fragments.films

import androidx.lifecycle.ViewModel
import com.example.filmsproject.domain.usecases.FilmUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    private val filmUseCase: FilmUseCase
): ViewModel() {
    fun getFilms() = filmUseCase()
}