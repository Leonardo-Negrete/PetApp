package com.example.login

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleSolicitudActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_solicitud)

        val nombre = intent.getStringExtra("nombre")
        val mascota = intent.getStringExtra("mascota")

        Log.d("DetalleSolicitud", "Nombre: $nombre, Mascota: $mascota")

        val nombreTextView = findViewById<TextView>(R.id.nombre_text_view)
        val mascotaTextView = findViewById<TextView>(R.id.mascota_text_view)

        if (!nombre.isNullOrEmpty()) {
            nombreTextView.text = nombre
        } else {
            nombreTextView.text = "Nombre no disponible"
        }

        if (!mascota.isNullOrEmpty()) {
            mascotaTextView.text = mascota
        } else {
            mascotaTextView.text = "Mascota no disponible"
        }
    }
}