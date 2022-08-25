package com.example.newstesttask.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newstesttask.repository.models.NewsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkRepository {

    private val retrofit = Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    private val _newsData = MutableLiveData<NewsData>()
    val newsData: LiveData<NewsData> = _newsData

    init {
        Log.d("ffffffffTAG", ": NetworkRepository")

    }

    fun loadGithubReposList() {

        Log.d("ffffffffTAG", ": NetworkRepository   loadGithubReposList()  ")

        val requestApiGithubRepos = retrofit.create(RequestApiNews::class.java)
        val call = requestApiGithubRepos.getRequest()

        call.enqueue(object : Callback<NewsData> {
            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                Log.d("ffffffffTAG", ": NetworkRepository   onFailure  ")

            }

            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
//                Log.d("ffffffffTAG", ": NetworkRepository   ${response.body().toString()}  ")

                if (response.isSuccessful) _newsData.value = response.body()

//                response.body()?.articles?.forEach{
//                    println(it.title)
//                    Log.d("ffffffffTAG", "onResponse: ${it.title}")
//                }

            }
        })
    }


}