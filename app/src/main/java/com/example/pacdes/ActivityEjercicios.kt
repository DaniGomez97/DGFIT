package com.example.pacdes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityEjercicios : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicios)

        //Asignamos ID con su botón y le damos funcionalidad
        val buttonVolver : Button = findViewById(R.id.btnVolver12)
        buttonVolver.setOnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }

        val buttonPecho : Button = findViewById(R.id.btn_pecho)
        buttonPecho.setOnClickListener {
            val intent = Intent (this, ActivityPectoral::class.java)
            startActivity(intent)
        }

        val buttonEspalda : Button = findViewById(R.id.btn_espalda)
        buttonEspalda.setOnClickListener {
            val intent = Intent (this, ActivityEspalda::class.java)
            startActivity(intent)
        }

        val buttonHombro : Button = findViewById(R.id.btn_hombro1)
        buttonHombro.setOnClickListener {
            val intent = Intent (this, ActivityHombro::class.java)
            startActivity(intent)
        }

        val buttonHombro2 : Button = findViewById(R.id.btn_hombro2)
        buttonHombro2.setOnClickListener {
            val intent = Intent (this, ActivityHombro::class.java)
            startActivity(intent)
        }

        val buttonPiernas : Button = findViewById(R.id.btn_pierna1)
        buttonPiernas.setOnClickListener {
            val intent = Intent (this, ActivityPierna::class.java)
            startActivity(intent)
        }

        val buttonPiernas2 : Button = findViewById(R.id.btn_pierna2)
        buttonPiernas2.setOnClickListener {
            val intent = Intent (this, ActivityPierna::class.java)
            startActivity(intent)
        }

        val buttonBrazos : Button = findViewById(R.id.btn_brazo1)
        buttonBrazos.setOnClickListener {
            val intent = Intent (this, ActivityBiceps::class.java)
            startActivity(intent)
        }

        val buttonTriceps : Button = findViewById(R.id.btn_triceps)
        buttonTriceps.setOnClickListener {
            val intent = Intent (this, ActivityTriceps::class.java)
            startActivity(intent)
        }
    }
}