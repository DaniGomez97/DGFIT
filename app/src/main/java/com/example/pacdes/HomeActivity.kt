package com.example.pacdes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth


class HomeActivity : AppCompatActivity() {

    //Declaramos variables sin asignar el valor todavia
    private lateinit var  logOutButton : Button
    private lateinit var emailTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Asignamos ID con su botón y le damos funcionalidad
        val buttonVolver : Button = findViewById(R.id.btnVolver)
        val buttonRutina : Button = findViewById(R.id.btnMiRutina)
        val buttonNutricion : Button = findViewById(R.id.btnNutricion)
        val buttonContactar : Button = findViewById(R.id.btnContactar)
        val buttonTarifas : Button = findViewById(R.id.btnTarifas2)


        buttonVolver.setOnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonRutina.setOnClickListener {
            val intent = Intent (this, MiRutina :: class.java) //Irá a la activity 6
            startActivity(intent)
        }

        buttonNutricion.setOnClickListener {
            val intent = Intent (this, MiNutricion :: class.java) //Irá a la activity 7
            startActivity(intent)
        }

        buttonTarifas.setOnClickListener {
            val intent = Intent (this, ActivityTarifasCliente :: class.java) //Irá a la activity 3
            startActivity(intent)
        }

        buttonContactar.setOnClickListener {
            val intent = Intent (this, ActivityContacta :: class.java) //Irá a la activity 8
            startActivity(intent)
            }

        //Setup
        val bundle : Bundle? = intent.extras
        val email : String? = bundle?.getString("email")
        setup(email?:"")
        }

        //Desarrollamos funcion setup
        private fun setup(email : String){
        title = "Inicio"

        logOutButton = findViewById(R.id.logOutButton)
        emailTextView = findViewById(R.id.emailTextView)

        emailTextView.text = email

        //Damos funcionalidad al botón de logout
        logOutButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Cerrar sesión")
            builder.setMessage("¿Estás seguro que deseas cerrar sesión?")
            builder.setPositiveButton("Sí") {
                _, _->
                FirebaseAuth.getInstance().signOut() //Cierra sesión
                val intent = Intent(this, AuthActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
            builder.setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
            builder.show()
            }
        }
    }




