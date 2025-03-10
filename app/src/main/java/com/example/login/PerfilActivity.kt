package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        // Obtener referencias a los TextView
        val tvEditarPerfil = findViewById<TextView>(R.id.tvEditarPerfil)
        val tvMetodosPago = findViewById<TextView>(R.id.tvMetodosPago)
        val tvFinalizarSesion = findViewById<TextView>(R.id.tvFinalizarSesion)

        // Navegar a EditarPerfilActivity
        tvEditarPerfil.setOnClickListener {
            val intent = Intent(this, EditarPerfilActivity::class.java)
            startActivity(intent)
        }

        // Navegar a MetodosPagoActivity
        tvMetodosPago.setOnClickListener {
            val intent = Intent(this, MetodosPagoActivity::class.java)
            startActivity(intent)
        }

        // Cerrar sesión y volver a la pantalla de login
        tvFinalizarSesion.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}
