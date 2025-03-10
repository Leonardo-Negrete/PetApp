package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainSolicitudes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.solicitudactivity_main)

        val contactButton: Button = findViewById(R.id.contact_button)
        val cardAlice: CardView = findViewById(R.id.card_alice)
        val cardMichael: CardView = findViewById(R.id.card_michael)
        val cardSophia: CardView = findViewById(R.id.card_sophia)

        contactButton.setOnClickListener {
            Toast.makeText(this, "Contacto presionado", Toast.LENGTH_SHORT).show()
        }

        cardAlice.setOnClickListener {
            val intent = Intent(this, DetalleSolicitudActivity::class.java)
            intent.putExtra("nombre", "Alice Johnson")
            intent.putExtra("mascota", "Bella") // Añadido
            startActivity(intent)
        }

        cardMichael.setOnClickListener {
            val intent = Intent(this, DetalleSolicitudActivity::class.java)
            intent.putExtra("nombre", "Michael Brown")
            intent.putExtra("mascota", "Max") // Añadido
            startActivity(intent)
        }

        cardSophia.setOnClickListener {
            val intent = Intent(this, DetalleSolicitudActivity::class.java)
            intent.putExtra("nombre", "Sophia Lee")
            intent.putExtra("mascota", "Luna") // Añadido
            startActivity(intent)
        }
        val profileIcon: ImageView = findViewById(R.id.profile_icon)
        profileIcon.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
        }
        // ... Agrega listeners para los ImageView del menú inferior si es necesario ...

    }
}