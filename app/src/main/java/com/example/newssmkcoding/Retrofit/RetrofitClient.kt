package com.example.crudfirebase.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    fun apiRequest(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://ec2-18-141-160-80.ap-southeast-1.compute.amazonaws.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}