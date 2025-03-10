package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class PantallaPrincipal : AppCompatActivity() {

    private lateinit var txtLogout: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_principal)

        txtLogout = findViewById<TextView>(R.id.logout)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*val textV =  findViewById<TextView>(R.id.mensaje)
        val texto:String = intent.extras?.getString("Extra_Texto").orEmpty()
        textV.text = "Bienvenido $texto"*/

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_inicio -> {
                    // Navegar a la pantalla de Inicio
                    val intento = Intent(this, MainActivity::class.java)
                    startActivity(intento)
                    finish()
                    true
                }
                R.id.nav_buscar -> {
                    // Navegar a la pantalla de Búsqueda
                    true
                }
                R.id.nav_perfil -> {
                    // Navegar a la pantalla de Perfil
                    true
                }
                R.id.nav_guardado -> {
                    // Navegar a la pantalla de Guardado
                    true
                }
                else -> false
            }
        }

        txtLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            Toast.makeText(this, "Sesión cerrada", Toast.LENGTH_SHORT).show()
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)
            finish()
        }
    }
}