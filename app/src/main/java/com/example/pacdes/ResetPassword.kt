package com.example.pacdes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class ResetPassword : AppCompatActivity() {

    //Declaramos variables sin asignar el valor todavia
    private lateinit var editTextEmail: EditText
    private lateinit var btnResetPassword : Button

    private lateinit var  email : String
    private lateinit var mAuth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        // Creamos las variables de los botones y damos funcionalidad con el setOnClick
        val buttonVolverAtras : Button = findViewById(R.id.btnVolver4)
        buttonVolverAtras.setOnClickListener {
            val intent = Intent (this, AuthActivity::class.java) //Función: ir al main.
            startActivity(intent)
        }

        mAuth = FirebaseAuth.getInstance()
        editTextEmail = findViewById(R.id.editTextEmail)
        btnResetPassword = findViewById(R.id.btnResetPassword)
        //Damos funcionalidad al botón de resetear contraseña
        btnResetPassword.setOnClickListener{
                if(editTextEmail.text.toString().isNotEmpty()){ //Si el campo del email no está vacío...
                    email = editTextEmail.text.toString()
                    resetPassword()
                }
                else {
                   showAlert()
                }
        }
    }
    //Función de mostrar alerta:
    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Revise el correo ingresado")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    //Función de resetear contraseña:
    private fun resetPassword(){
        mAuth.setLanguageCode("es")
            mAuth.sendPasswordResetEmail(email).addOnCompleteListener{task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "Se ha enviado un correo para restablecer la contraseña", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this, "No se pudo enviar el correo de restablecimiento", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

