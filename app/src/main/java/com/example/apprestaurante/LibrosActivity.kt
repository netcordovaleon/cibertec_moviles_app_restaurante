package com.example.apprestaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.apprestaurante.RestauranteREST.QuoteAPI
import com.example.apprestaurante.RestauranteREST.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LibrosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_libros)

        val quotesAPI = RetrofitHelper.getRetrofitInstance().create(QuoteAPI::class.java)

        GlobalScope.launch {
            val result = quotesAPI.getQuotes()
            if (result != null)
                Log.d("CIBER REST RESPONSE: ", result.body().toString())
        }

    }
}