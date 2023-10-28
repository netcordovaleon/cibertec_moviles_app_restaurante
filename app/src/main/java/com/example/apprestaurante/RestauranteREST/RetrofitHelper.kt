package com.example.apprestaurante.RestauranteREST

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    val baseUrl = "https://quotable.io/"
    fun getRetrofitInstance() : Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
             .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}