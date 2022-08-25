package com.example.newstesttask.presentation.interfaces

import androidx.lifecycle.LiveData

interface ListNewsViewModel {

//    val adapter: LiveData<CustomRecyclerAdapter>
    fun getAdapter(query: String)
}