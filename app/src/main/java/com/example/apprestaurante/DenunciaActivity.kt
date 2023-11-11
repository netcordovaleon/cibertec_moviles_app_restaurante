package com.example.apprestaurante

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class DenunciaActivity : AppCompatActivity() {

    lateinit var imageDenuncia : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_denuncia)

        val btnTomarFotoDenuncia : Button = findViewById(R.id.btnCamara)
        imageDenuncia = findViewById(R.id.imgDenuncia)

        btnTomarFotoDenuncia.setOnClickListener{
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, pic_id)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == pic_id ) {
            val photo = data!!.extras!!["data"] as Bitmap?
            imageDenuncia.setImageBitmap(photo)
        }
    }
    companion object {

        private const val pic_id = 123

    }
}