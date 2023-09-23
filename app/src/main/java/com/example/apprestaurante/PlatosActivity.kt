package com.example.apprestaurante

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PlatosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        val nombresPlatosList = mutableListOf<String>();
        val descripcionPlatosList = mutableListOf<String>();
        val ImagenesPlatosList = mutableListOf<String>();

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_platos)

        val btnCerrarSesion: Button = findViewById(R.id.btnCerrarSesion)

        val rv_list_platos: RecyclerView = findViewById(R.id.rv_list_platos)

        btnCerrarSesion.setOnClickListener{

            val titleMsg: String = "Confirmación"
            val bodyMsg: String = "¿Esta seguro que desea salir de la App?"

            showModalConfirmExit(titleMsg, bodyMsg);

        }

        rv_list_platos.layoutManager = LinearLayoutManager(this);

        rv_list_platos.adapter = null; //EL PROVEEDOR DE LA INFORMACION (SERVICIO, LOCALSTORAGE, LISTA SIMPLES)


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