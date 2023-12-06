package com.example.pacdes

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class ActivityTarifas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarifas)

        //Asignamos ID con su botón y le damos funcionalidad
        val btnPresencial: Button = findViewById(R.id.btnTarifaPresencial)
        btnPresencial.setOnClickListener {
            val intent = Intent(this, ActivityPresencial::class.java) //Función: ir al main.
            startActivity(intent)
        }

        val btnOnline: Button = findViewById(R.id.btnTarifaOnline)
        btnOnline.setOnClickListener {
            val intent = Intent(this, ActivityOnline::class.java) //Función: ir al main.
            startActivity(intent)
        }

        val btnNutricion: Button = findViewById(R.id.btnTarifaNutricion)
        btnNutricion.setOnClickListener {
            val intent = Intent(this, ActivityNutricion::class.java) //Función: ir al main.
            startActivity(intent)
        }

        val buttonVolverAtras2: Button = findViewById(R.id.btnVolver2)
        buttonVolverAtras2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java) //Función: ir al main.
            startActivity(intent)
        }
        //Funvion de abrir el correo con los datos escritos
        val buttonContactar2: Button = findViewById(R.id.btnContactar2)
        buttonContactar2.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:dgfit.97@gmail.com?subject=Solicitud%20entrenamientos%20")
            }
            // Verifica si hay alguna app que pueda manejar la acción de enviar correo electrónico
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}