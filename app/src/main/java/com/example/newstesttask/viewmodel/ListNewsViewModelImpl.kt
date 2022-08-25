package com.example.newstesttask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newstesttask.domain.CustomRecyclerAdapter
import com.example.newstesttask.domain.GetAdapterNewsUseCase
import com.example.newstesttask.presentation.interfaces.ListNewsViewModel

class ListNewsViewModelImpl(private val getAdapterNewsUseCase: GetAdapterNewsUseCase) : ViewModel(),
    ListNewsViewModel {

    private var _adapter = MutableLiveData<CustomRecyclerAdapter>()
    override val adapter: LiveData<CustomRecyclerAdapter> = _adapter

    override fun getAdapter(query: String) {
        getAdapterNewsUseCase.adapter.observeForever {
            _adapter.value = it
        }
        getAdapterNewsUseCase.start()
    }
}