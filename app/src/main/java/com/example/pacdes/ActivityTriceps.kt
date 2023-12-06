package com.example.pacdes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityTriceps : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_triceps)

        //Asignamos ID con su botón y le damos funcionalidad
        val buttonVolver : Button = findViewById(R.id.btnVolver13)
        buttonVolver.setOnClickListener {
            val intent = Intent (this, ActivityEjercicios::class.java)
            startActivity(intent)
        }
    }
}