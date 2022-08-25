package com.example.newstesttask.presentation.interfaces

import androidx.lifecycle.LiveData
import com.example.newstesttask.domain.CustomRecyclerAdapter

interface ListNewsViewModel {
    val adapter: LiveData<CustomRecyclerAdapter>
    fun getAdapter(query: String)
}