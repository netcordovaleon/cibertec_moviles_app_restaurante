package com.example.apprestaurante

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apprestaurante.RestauranteRecyclerView.CustomAdapter
import com.example.apprestaurante.RestauranteRecyclerView.ItemsViewModel

class PlatosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_platos)

        // INICIO CODIGO PARA BOTON CERRAR SESSION
        val btnCerrarSesion: Button = findViewById(R.id.btnCerrarSesion)

        btnCerrarSesion.setOnClickListener{
            val titleMsg: String = "Confirmación"
            val bodyMsg: String = "¿Esta seguro que desea salir de la App?"
            showModalConfirmExit(titleMsg, bodyMsg);
        }
        // FIN CODIGO PARA BOTON CERRAR SESSION

        // INICIO CARGAR PLATOS EN REPEATERVIEW

        val platosRecycler: RecyclerView = findViewById(R.id.rv_list_platos)
        platosRecycler.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ItemsViewModel>();
        //Aqui tambien podrian obtener informacion de alguna fuente para llenar DATA (como servicios, archivos, BD, etc)
        for(i in 1 .. 20){
            data.add(ItemsViewModel(R.drawable.bg_restaurante_background, "Plato de comida Nro " + i, "Descripcion " + i))
        }
        val adapter = CustomAdapter(data)
        platosRecycler.adapter = adapter

        // FIN CARGAR PLATOS EN REPEATERVIEW

        // INI REDIRECCION A CONSUMO REST

        val btnVerLibros: Button = findViewById(R.id.btnVerLibrosCocina)

        btnVerLibros.setOnClickListener {
            val pantallaVerLibros = Intent(this, LibrosActivity::class.java)
            startActivity(pantallaVerLibros)
        }
        // FIN REDIRECCION A CONSUMO REST


        // INICIO IR A RECLAMOS

        val btnGenerarDenuncia: Button = findViewById(R.id.btnGenerarDenuncia)

        btnGenerarDenuncia.setOnClickListener {
            val denunciaActivity = Intent(this, DenunciaActivity::class.java)
            startActivity(denunciaActivity)
        }
        // FIN IR A RECLAMOS
    }

    private fun showModalConfirmExit(titleMsg: String, bodyMsg: String) {
        val dialogConfirm = Dialog(this)
        dialogConfirm.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogConfirm.setCancelable(false)
        dialogConfirm.setContentView(R.layout.custom_modal_dialog)

        dialogConfirm.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        //INICIO

        val titleModal : TextView = dialogConfirm.findViewById(R.id.modalTitle)
        val bodyMsgModal : TextView = dialogConfirm.findViewById(R.id.modalMessage)

        val btnAceptar : Button = dialogConfirm.findViewById(R.id.btnModalAceptar)
        val btnCancelar: Button = dialogConfirm.findViewById(R.id.btnModalCancelar)

        titleModal.text = titleMsg
        bodyMsgModal.text = bodyMsg

        btnAceptar.setOnClickListener {
            val pantallPrincipal = Intent(this, PantallaPrincipalActivity::class.java)
            startActivity(pantallPrincipal)
        }

        btnCancelar.setOnClickListener {
            Toast.makeText(this, "Sigue comprando =D", Toast.LENGTH_LONG).show()
            dialogConfirm.dismiss()
        }

        dialogConfirm.show()
    }
}