package com.example.apprestaurante.RestauranteREST

import retrofit2.Response
import retrofit2.http.GET

interface QuoteAPI {
    @GET("/quotes?page=1")
    fun getQuotes(): Response<QuotesList>
}