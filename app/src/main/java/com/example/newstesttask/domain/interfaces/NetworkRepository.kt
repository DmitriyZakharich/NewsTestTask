package com.example.newstesttask.domain.interfaces

import androidx.lifecycle.LiveData
import com.example.newstesttask.repository.models.NewsData

interface NetworkRepository {
    val newsData: LiveData<NewsData>
    fun loadGithubReposList()
}