package com.example.newstesttask.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.newstesttask.domain.interfaces.NetworkRepository
import com.example.newstesttask.repository.models.NewsData
import com.example.newstesttask.viewmodel.interfaces.GetAdapterNewsUseCase

class GetAdapterNewsUseCaseImpl(private val networkRepository: NetworkRepository) :
    GetAdapterNewsUseCase {

    private var _adapter: MutableLiveData<CustomRecyclerAdapter> = MutableLiveData()
    override var adapter: LiveData<CustomRecyclerAdapter> = _adapter

    init {
        networkRepository.newsData.observeForever(observer())
    }

    private fun observer() = Observer<NewsData> { data ->
        val newsData = mapperRepositoryToDomain(data)
        _adapter.value = CustomRecyclerAdapter(newsData.articles)
    }

    override fun start() {
        networkRepository.loadGithubReposList()
    }
}