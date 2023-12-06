package com.example.pacdes

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Asignamos ID con su botón y le damos funcionalidad
        val buttonEjercicios : Button = findViewById(R.id.btnEjercicios)
        val buttonInstagram : Button = findViewById(R.id.btnInstagram)
        val buttonTarifas : Button = findViewById(R.id.btnTarifas)
        val buttonIniSes : Button = findViewById(R.id.btn_ini_ses)
        val buttonConsejos : Button = findViewById(R.id.btnConsejos)

        buttonIniSes.setOnClickListener {
            val intent = Intent (this, AuthActivity :: class.java) //Irá a la activity 2
            startActivity(intent)
        }

        buttonEjercicios.setOnClickListener {
            val intent = Intent (this, ActivityEjercicios :: class.java) //Irá a la activity 2
            startActivity(intent)
        }

        buttonInstagram.setOnClickListener {
            //Variable de la url
            val url = "https://www.instagram.com/dgfit.97"
            //Creamos la variable intent
            val intent = Intent(Intent.ACTION_VIEW)
            //Le decimos al intent la URL que quueremos que abra
            intent.data = Uri.parse(url)
            //Inicia actividad en navegador
            startActivity(intent)
        }

        buttonTarifas.setOnClickListener {
            val intent = Intent (this, ActivityTarifas :: class.java) //Irá a la activity 4
            startActivity(intent)
        }

        buttonConsejos.setOnClickListener {
            val intent = Intent (this, ActivityConsejos :: class.java) //Irá a la activity 4
            startActivity(intent)
        }

        buttonIniSes.setOnClickListener {
            val intent = Intent (this, AuthActivity :: class.java) //Irá a la activity 4
            startActivity(intent)
        }
    }
}