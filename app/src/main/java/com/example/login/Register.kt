package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var user: EditText
    private lateinit var psw: EditText
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()
        user = findViewById<EditText>(R.id.email)
        psw = findViewById<EditText>(R.id.password)
        btnRegister = findViewById<Button>(R.id.register)
        val loginTextView = findViewById<TextView>(R.id.loginText)

        loginTextView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnRegister.setOnClickListener {
            val correo = user.text.toString().trim()
            val contra = psw.text.toString().trim()
            if (correo.isNotEmpty() && contra.isNotEmpty()) {
                register(correo, contra)
            } else {
                Toast.makeText(this, "Ingresa las credenciales", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun register(correo: String, contra: String) {
        auth.createUserWithEmailAndPassword(correo, contra)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
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
