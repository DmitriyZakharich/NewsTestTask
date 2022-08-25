package com.example.newstesttask.viewmodel.interfaces

import androidx.lifecycle.LiveData
import com.example.newstesttask.domain.CustomRecyclerAdapter

interface GetAdapterNewsUseCase {
    var adapter: LiveData<CustomRecyclerAdapter>
    fun start()
}