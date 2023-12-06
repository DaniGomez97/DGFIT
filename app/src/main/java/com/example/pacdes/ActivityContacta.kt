package com.example.pacdes

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class ActivityContacta : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacta)

        //Creamos variables con los botones
        val buttonVolver : Button = findViewById(R.id.btnVolver8)
        val buttonDudaEntrenamiento : Button = findViewById(R.id.btnDudaRutina)
        val buttonDudaNutricion : Button = findViewById(R.id.btnDudaNutricion)
        val buttonOtraDuda: Button = findViewById(R.id.btnOtraDuda)
        val logo:ImageView = findViewById(R.id.logo3)

        //Creamos sus respectivas funciones
        buttonVolver.setOnClickListener {
            val intent = Intent (this, HomeActivity :: class.java)
            startActivity(intent)
        }
        logo.setOnClickListener {
            val intent = Intent (this, HomeActivity :: class.java)
            startActivity(intent)
        }
        buttonDudaEntrenamiento.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:dgfit.97@gmail.com?subject=Dudas%20con%20mi%20tabla%20de%20entrenamiento")
            }
            // Verifica si hay alguna app que pueda manejar la acción de enviar correo electrónico
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
        buttonDudaNutricion.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:dgfit.97@gmail.com?subject=Dudas%20con%20mi%20tabla%20de%20nutrición")
            }
            // Verifica si hay alguna app que pueda manejar la acción de enviar correo electrónico
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
        buttonOtraDuda.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:dgfit.97@gmail.com?subject=Tengo%20una%20duda%20")
            }
            // Verifica si hay alguna app que pueda manejar la acción de enviar correo electrónico
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}