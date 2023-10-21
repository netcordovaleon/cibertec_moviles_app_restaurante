package com.example.apprestaurante

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CustomAdapter (private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(ItemView :View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = ItemView.findViewById(R.id.img_plato)
        val tituloPrincipal: TextView = ItemView.findViewById(R.id.lbl_nombre_plato)
        val descripcionSecundaria: TextView = ItemView.findViewById(R.id.lbl_descripcion_plato)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_platos, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //Si deseo alguna conexion PODRIA SER AQUI (BD, SERVICIO WEB, ETC
        val itemViewModel = mList[position]

        holder.imageView.setImageResource(itemViewModel.image)
        holder.tituloPrincipal.text = itemViewModel.titulo
        holder.descripcionSecundaria.text = itemViewModel.descripcion

    }

}






















