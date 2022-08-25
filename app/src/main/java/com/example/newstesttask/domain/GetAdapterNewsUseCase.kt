package com.example.newstesttask.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.newstesttask.repository.NetworkRepository
import com.example.newstesttask.repository.models.NewsData

class GetAdapterNewsUseCase(private val networkRepository: NetworkRepository) {

    private var _adapter: MutableLiveData<CustomRecyclerAdapter> = MutableLiveData()
    var adapter: LiveData<CustomRecyclerAdapter> = _adapter

    init {
        networkRepository.newsData.observeForever(observer())

    }

    private fun observer() = Observer<NewsData> { data ->
        _adapter.value = CustomRecyclerAdapter(data.articles)
    }

    fun start() {
        networkRepository.loadGithubReposList()
    }
}