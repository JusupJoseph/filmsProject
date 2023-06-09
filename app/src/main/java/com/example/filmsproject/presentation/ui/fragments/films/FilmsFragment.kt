package com.example.filmsproject.presentation.ui.fragments.films

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.filmsproject.R
import com.example.filmsproject.databinding.FragmentFilmBinding
import com.example.filmsproject.presentation.base.BaseFragment
import com.example.filmsproject.presentation.models.toUI
import com.example.filmsproject.presentation.ui.adapters.FilmsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmsFragment : BaseFragment<FragmentFilmBinding, FilmsViewModel>(R.layout.fragment_film) {

    override val binding: FragmentFilmBinding by viewBinding(FragmentFilmBinding::bind)
    override val viewModel: FilmsViewModel by viewModels()
    private val filmsAdapter = FilmsAdapter()


    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribe() {
        viewModel.getFilms().subscribe(
            left = {
                Log.e("error", it)
            },
            right = {
                val mapList = it.map { it.toUI() }
                filmsAdapter.submitList(mapList)
            }
        )
    }

    private fun setupRecyclerView() {
        binding.rvFilms.adapter = filmsAdapter
    }
}