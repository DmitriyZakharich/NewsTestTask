package com.example.newstesttask.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newstesttask.domain.interfaces.NetworkRepository
import com.example.newstesttask.repository.models.NewsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkRepositoryImpl : NetworkRepository {

    private val retrofit = Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    private val _newsData = MutableLiveData<NewsData>()
    override val newsData: LiveData<NewsData> = _newsData

    override fun loadGithubReposList() {
        val requestApiGithubRepos = retrofit.create(RequestApiNews::class.java)
        val call = requestApiGithubRepos.getRequest()

        call.enqueue(object : Callback<NewsData> {
            override fun onFailure(call: Call<NewsData>, t: Throwable) {}

            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                if (response.isSuccessful) _newsData.value = response.body()
            }
        })
    }
}