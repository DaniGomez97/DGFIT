package com.example.pacdes

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class ActivityTarifasCliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarifas_cliente)

        //Asignamos ID con su botón y le damos funcionalidad
        val codigosDesc = arrayOf("D7G7F7", "DESC10GD", "1FITDG0", "D10FIT", "DG10FIT")
        var codigoGenerado : String? = null

        val buttonContacta :Button = findViewById(R.id.btnContactar5)
        val buttonVolver : Button = findViewById(R.id.btnVolver15)
        val buttonDescuento : Button =findViewById(R.id.btnDescuento)

        buttonVolver.setOnClickListener {
            val intent = Intent (this, HomeActivity::class.java)
            startActivity(intent)
        }
        buttonContacta.setOnClickListener{
            val intent2 = Intent (this, ActivityForm::class.java)
            startActivity(intent2)
        }

        buttonDescuento.setOnClickListener {
            if(codigoGenerado == null) { //Si no se ha generado un código
                val random = (codigosDesc.indices).random() //Te da uno aleatorio del array
                codigoGenerado = codigosDesc[random] //Se lo da a la variable codigogenerado
                val builder = AlertDialog.Builder(this)
                builder.setTitle("CÓDIGO DE CLIENTE GENERADO")
                builder.setMessage("Aquí tienes tu código de descuento: $codigoGenerado")
                builder.setPositiveButton("Aceptar", null)
                builder.setNeutralButton("Copiar"){_,_ ->
                    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE)as ClipboardManager
                    val clip = ClipData.newPlainText("Código de descuento", codigoGenerado)
                    clipboard.setPrimaryClip(clip)
                    Toast.makeText(this, "Codigo copiado al portapapeles", Toast.LENGTH_SHORT).show()
                }
                val dialog: AlertDialog = builder.create()
                dialog.show()
            }else {
                Toast.makeText(this, "Solo se puede generar un código por usuario", Toast.LENGTH_SHORT).show()
            }
        }
    }
}