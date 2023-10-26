package com.example.apprestaurante.RestauranteREST

data class QuotesList(
    val count:Int,
    val totalCount: Int,
    val page: Int,
    val totalPages: Int,
    val lastItemIndex: Int,
    val results: List<Result>
)