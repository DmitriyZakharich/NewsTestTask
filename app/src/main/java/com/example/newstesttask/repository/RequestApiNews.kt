package com.example.newstesttask.repository

import com.example.newstesttask.repository.models.NewsData
import retrofit2.Call
import retrofit2.http.GET

interface RequestApiNews {

    @GET("everything?q=tesla&apiKey=e538114e876342ca87a22af88190d3b4")
    fun getRequest(): Call<NewsData>

}