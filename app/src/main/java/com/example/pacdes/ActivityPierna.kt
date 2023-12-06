package com.example.pacdes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityPierna : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pierna)

        //Asignamos ID con su botón y le damos funcionalidad
        val buttonVolverPierna : Button = findViewById(R.id.btnVolver)
        buttonVolverPierna.setOnClickListener {
            val intent = Intent (this, ActivityEjercicios::class.java)
            startActivity(intent)
        }

    }
}