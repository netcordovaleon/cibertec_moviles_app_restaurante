package com.example.apprestaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apprestaurante.RestauranteREST.CustomLibrosAdapter
import com.example.apprestaurante.RestauranteREST.LibrosViewModels
import com.example.apprestaurante.RestauranteREST.QuoteAPI
import com.example.apprestaurante.RestauranteREST.RetrofitHelper
import com.example.apprestaurante.RestauranteRecyclerView.CustomAdapter
import com.example.apprestaurante.RestauranteRecyclerView.ItemsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

//user09 - 123
class LibrosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_libros)

        val quotesAPI = RetrofitHelper.getRetrofitInstance().create(QuoteAPI::class.java)

        val data = ArrayList<LibrosViewModels>();

        val librosRecycler: RecyclerView = findViewById(R.id.rv_list_libros)
        librosRecycler.layoutManager = LinearLayoutManager(this)


        GlobalScope.launch {
            val result = quotesAPI.getQuotes()
            if (result != null)
                //Log.d("CIBER REST RESPONSE: ", result.body().toString())

                for (i in 0..result.body()?.results!!.count()-1){
                    val autor = result.body()!!.results!!.get(i).author;
                    val content = result.body()!!.results!!.get(i).content;
                    data.add(LibrosViewModels(autor, content));
                }
            val ejemplo = data.count();
            runOnUiThread {
                val adapter = CustomLibrosAdapter(data)
                librosRecycler.adapter = adapter
            }
        }

    }
}