package com.example.pacdes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityEspalda : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_espalda)

        //Asignamos ID con su botón y le damos funcionalidad
        val buttonVolverEspalda : Button = findViewById(R.id.btnVolver)
        buttonVolverEspalda.setOnClickListener {
            val intent = Intent (this, ActivityEjercicios::class.java)
            startActivity(intent)
        }

    }
}