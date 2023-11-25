package com.example.apprestaurante.RestauranteREST

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apprestaurante.R


class CustomLibrosAdapter (private val mList: List<LibrosViewModels>) : RecyclerView.Adapter<CustomLibrosAdapter.ViewHolder>() {


    class ViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView) {
        val nombreLibro: TextView = ItemView.findViewById(R.id.lbl_nombre_libro)
        val descripcionLibro: TextView = ItemView.findViewById(R.id.lbl_descripcion_libro)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_libros, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //Si deseo alguna conexion PODRIA SER AQUI (BD, SERVICIO WEB, ETC
        val itemViewModel = mList[position]

        holder.nombreLibro.text = itemViewModel.author
        holder.descripcionLibro.text = itemViewModel.content

    }

}