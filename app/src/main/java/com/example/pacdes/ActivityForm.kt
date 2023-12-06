package com.example.pacdes

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class ActivityForm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        //Array con los codigos que hemos otorgado a los clientes
        val codigosDesc = arrayOf("D7G7F7", "DESC10GD", "1FITDG0", "D10FIT", "DG10FIT")

        //Asignamos ID con su botón, editText o check y le damos funcionalidad
        val buttonVolver: Button = findViewById(R.id.btnVolver11)

        val etCorreo: EditText = findViewById(R.id.etCorreo)
        val etCodigo: EditText = findViewById(R.id.etCodigo)

        val checkPresencial: CheckBox = findViewById(R.id.checkPresencial)
        val checkOnline: CheckBox = findViewById(R.id.checkOnline)
        val checkNutricion: CheckBox = findViewById(R.id.checkNutricion)

        val buttonEnviar: Button = findViewById(R.id.btnEnviar)

        //Aquí las funciones:
        buttonEnviar.setOnClickListener {
            val correo = etCorreo.text.toString()
            val codigo = etCodigo.text.toString()

            //Comprobamos que el codigo utilizado por el usuario está en nuesttro array
            if (!codigosDesc.contains(codigo)) {
                Toast.makeText(this, "El código ingresado no es válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //Vamos a obtener el valor del Check
            val asunto = mutableListOf<String>()
            if(checkPresencial.isChecked) {
                asunto.add("Presencial")
            }
            if(checkOnline.isChecked) {
                asunto.add("Online")
            }
            if(checkNutricion.isChecked) {
            asunto.add("Nutrición")
            }

            if(asunto.isEmpty()){
                val builder = AlertDialog.Builder(this)
                builder.setTitle("ERROR")
                builder.setMessage("Debe seleccionar una opción")
                builder.setPositiveButton("Aceptar", null)
                val dialog: AlertDialog = builder.create()
                dialog.show()
                return@setOnClickListener
            }
            //Abrimos el correo y le indicamos lo que queremos que ponga
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto: dgfit.97@gmail.com?subject=El usuario $correo está interesado en: ${asunto.joinToString(separator = ", ")}\nCodigo: $codigo")
                putExtra(Intent.EXTRA_TEXT, "El usuario $correo está interesado en: ${asunto.joinToString(separator = ", ")}\nCodigo: $codigo")
            }

        // Verifica si hay alguna app que pueda manejar la acción de enviar correo electrónico
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else { //Si no la hay, manda un Toast
            Toast.makeText(
                this,
                "No hay aplicaciones disponibles para enviar el mensaje",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
            buttonVolver.setOnClickListener {
                val intent = Intent(this, ActivityTarifasCliente::class.java)
                startActivity(intent)
            }
        }
    }

