package com.example.newstesttask.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newstesttask.domain.GetAdapterNewsUseCase

class ListNewsViewModelFactory(private val getAdapterNewsUseCase: GetAdapterNewsUseCase) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListNewsViewModelImpl(getAdapterNewsUseCase) as T
    }
}