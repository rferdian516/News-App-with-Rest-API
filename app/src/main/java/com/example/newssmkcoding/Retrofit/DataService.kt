package com.example.crudfirebase.retrofit

import com.example.newssmkcoding.Response.ResponseNews
import retrofit2.Call
import retrofit2.http.GET

interface DataService {
    @GET("api/news")
    fun getNews(): Call<ResponseNews>
}