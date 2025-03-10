package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var user: EditText
    private lateinit var psw: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        //Si ya está autenticado, lo mandamos a la pantalla principal
        if (auth.currentUser != null) {
            val intento = Intent(this, PantallaPrincipal::class.java)
            intento.putExtra("Extra_Texto", auth.currentUser?.email)
            startActivity(intento)
            finish() // Cerramos esta pantalla
        }

        user = findViewById<EditText>(R.id.email)
        psw = findViewById<EditText>(R.id.password)
        btnLogin = findViewById<Button>(R.id.login)
        val registerTextView = findViewById<TextView>(R.id.registerText)

        registerTextView.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val correo = user.text.toString().trim()
            val contra = psw.text.toString().trim()
            if (correo.isNotEmpty() && contra.isNotEmpty()) {
                login(correo, contra)
            } else {
                Toast.makeText(this, "Ingresa las credenciales", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun login(correo: String, contra: String) {
        auth.signInWithEmailAndPassword(correo, contra)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Login exitoso", Toast.LENGTH_SHORT).show()
                    val intento = Intent(this, PantallaPrincipal::class.java)
                    intento.putExtra("Extra_Texto", correo)
                    startActivity(intento)
                    finish()
                } else {
                    Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}