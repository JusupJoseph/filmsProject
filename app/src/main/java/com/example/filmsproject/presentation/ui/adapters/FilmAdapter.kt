package com.example.filmsproject.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.filmsproject.databinding.FilmsItemListBinding
import com.example.filmsproject.presentation.base.BaseDiffUtilItemCallback
import com.example.filmsproject.presentation.models.FilmModelUI

class FilmsAdapter() :
    ListAdapter<FilmModelUI, FilmsAdapter.FilmsViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder =
        FilmsViewHolder(
            FilmsItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class FilmsViewHolder(private val binding: FilmsItemListBinding) : ViewHolder(binding.root) {

        fun onBind(filmModelUI: FilmModelUI) {
            with(binding) {
                nameMovie.text = filmModelUI.title
                movieImage.load(filmModelUI.image)
            }
        }
    }
}