package com.example.apprestaurante.RestauranteREST

data class Result (
    val author:String,
    val content:String,
    val tags: List<String>,
    val authorSlug: String
)