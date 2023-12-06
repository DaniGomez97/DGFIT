package com.example.pacdes

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ActivityNutricion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entrenamiento_nutricion)

        //Asignamos ID con su botón y le damos funcionalidad
        val buttonVolver : Button = findViewById(R.id.btnVolver10)
        buttonVolver.setOnClickListener {
            val intent = Intent (this, ActivityTarifas :: class.java)
            startActivity(intent)
        }

    }
}