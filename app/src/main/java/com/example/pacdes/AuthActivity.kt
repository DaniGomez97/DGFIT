package com.example.pacdes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class AuthActivity : AppCompatActivity() {

 //Declaramos variables sin asignar el valor todavia
 private lateinit var logInButton : Button
 private lateinit var emailEditText: EditText
 private lateinit var passwordEditText: EditText
 private lateinit var forgetButtton : Button

 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContentView(R.layout.activity_auth)

 // Creamos las variables de los botones y damos funcionalidad con el setOnClick
 val buttonVolverAtras : Button = findViewById(R.id.btnVolver1)
  buttonVolverAtras.setOnClickListener {
   val intent = Intent (this, MainActivity::class.java) //Función: ir al main.
   startActivity(intent)}

  //BASE DE DATOS FIREBASE:
  setup() //Lo desarrollamos debajo
 }

 //Desarrollo función setup
  private fun setup(){
   title = "Autenticación"
   //Asignamos los ID con los botones que usaremos para conectar con Firebase

   emailEditText = findViewById(R.id.emailEditText)
   passwordEditText = findViewById(R.id.passwordEditText)

  //Botón Olvidé contraseña
   forgetButtton = findViewById(R.id.btnOlvid)
   forgetButtton.setOnClickListener {
    val intentOlvid = Intent (this, ResetPassword::class.java) //Función: ir a la pantalla de resetear contraseña
    startActivity(intentOlvid)}

   //Botón iniciar sesión
   logInButton = findViewById(R.id.loginButton)
   logInButton.setOnClickListener {
    if (emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()){ //Si los campos no están vacíos...

      FirebaseAuth.getInstance().signInWithEmailAndPassword(emailEditText.text.toString() ,  //Coge los textView, transfórmalos a String
      passwordEditText.text.toString()).addOnCompleteListener {

       if (it.isSuccessful) { //Si son correctos...
        showHome(it.result?.user?.email ?: "") //Ejecuta la función de showHome (Desarrollada debajo)
       } else {
        showAlert() //Sino muestra alerta (Desarrollada debajo)
       }
      }
    }
   }
 }

 //Función: Muestra error
 private fun showAlert(){
   val builder = AlertDialog.Builder(this)
    builder.setTitle("Error")
     builder.setMessage("El usuario o la contraseña son incorrectos")
     builder.setPositiveButton("Aceptar", null)
    val dialog: AlertDialog = builder.create()
   dialog.show()
 }

 //Función: Muestra pantalla del área privada
 private fun showHome(email:String){
  val homeIntent = Intent(this, HomeActivity::class.java).apply {
   putExtra("email", email)
  }
  startActivity(homeIntent)
 }
}