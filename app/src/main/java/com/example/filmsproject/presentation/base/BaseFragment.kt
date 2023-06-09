package com.example.filmsproject.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.example.filmsproject.domain.common.Either
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(@LayoutRes layoutId: Int) :
    Fragment(layoutId) {

    protected abstract val binding: VB
    protected abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        setupListener()
        setupSubscribe()
        setupRequest()
    }

    protected open fun initialize() {}

    protected open fun setupListener() {}

    protected open fun setupSubscribe() {}

    protected open fun setupRequest() {}

    protected open fun <T> Flow<Either<String, List<T>>>.subscribe(
        left: (error: String) -> Unit,
        right: ((data: List<T>) -> Unit),
    ) {
        lifecycleScope.launch {
            collect { either ->
                when (either) {
                    is Either.Left -> {
                        left(either.message.toString())
                    }
                    is Either.Right -> {
                        either.data?.let { data ->
                            right(data)
                        }
                    }
                }
            }
        }
    }
}