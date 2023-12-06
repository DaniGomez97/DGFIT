package com.example.pacdes

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MiRutina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_rutina)

        //Creamos variable para el UID y la Base de Datos
        val db : FirebaseFirestore = FirebaseFirestore.getInstance()
        val mAuth: FirebaseAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser
        //Ahora los textview donde veremos la info

        val txtNomb1 : TextView = findViewById(R.id.txtNomb1)
        val txtSeries1 : TextView = findViewById(R.id.txtSeries1)
        val txtRep1 : TextView = findViewById(R.id.txtRep1)
        val txtPeso1 : TextView = findViewById(R.id.txtPeso1)

        val txtNomb2: TextView = findViewById(R.id.txtNomb2)
        val txtSeries2 : TextView = findViewById(R.id.txtSeries2)
        val txtRep2 : TextView = findViewById(R.id.txtRep2)
        val txtPeso2 : TextView = findViewById(R.id.txtPeso2)

        val txtNomb3 : TextView = findViewById(R.id.txtNomb3)
        val txtSeries3 : TextView = findViewById(R.id.txtSeries3)
        val txtRep3 : TextView = findViewById(R.id.txtRep3)
        val txtPeso3 : TextView = findViewById(R.id.txtPeso3)

        val txtNomb4 : TextView = findViewById(R.id.txtNomb4)
        val txtSeries4 : TextView = findViewById(R.id.txtSeries4)
        val txtRep4 : TextView = findViewById(R.id.txtRep4)
        val txtPeso4 : TextView = findViewById(R.id.txtPeso4)


        //Si el usuario no es null
        if (currentUser != null) {
            val userId = currentUser.uid //Obtén su referencia
            val docRef = db.collection("Entrenamiento").document(userId)   //Busca en la db la coleccion "Entrenamientos" con el documento referente al ID del user
            docRef.get().addOnSuccessListener{document->
                if (document != null && document.exists()){
                    //Obtenemos los datos de cada campo de la BD y lo ponemos en los TextView

                    //Nombre de los ej
                    val nomb1= document.getString("nomb1")
                    txtNomb1.text = nomb1

                    val nomb2= document.getString("nomb2")
                    txtNomb2.text = nomb2
                    val nomb3= document.getString("nomb3")
                    txtNomb3.text = nomb3
                    val nomb4= document.getString("nomb4")
                    txtNomb4.text = nomb4
                    Log.d(TAG, "Mensaje de registro")
                    //Series de los ej
                    val series1= document.getString("series1")
                    txtSeries1.text = series1
                    val series2= document.getString("series2")
                    txtSeries2.text = series2
                    val series3= document.getString("series3")
                    txtSeries3.text = series3
                    val series4= document.getString("series4")
                    txtSeries4.text = series4
                    Log.d(TAG, "Mensaje de registro")

                    //Repeticiones de los ej
                    val rep1= document.getString("rep1")
                    txtRep1.text = rep1
                    val rep2= document.getString("rep2")
                    txtRep2.text = rep2
                    val rep3= document.getString("rep3")
                    txtRep3.text = rep3
                    val rep4= document.getString("rep4")
                    txtRep4.text = rep4

                    //Peso de los ej
                    val peso1= document.getString("peso1")
                    txtPeso1.text = peso1
                    val peso2= document.getString("peso2")
                    txtPeso2.text = peso2
                    val peso3= document.getString("peso3")
                    txtPeso3.text = peso3
                    val peso4= document.getString("peso4")
                    txtPeso4.text = peso4.toString()

                } else{ //Si no, muestra el mensaje de: "No hay datos disponibles"
                    txtNomb1.text = "No hay datos disponibles"
                    txtNomb2.text = "No hay datos disponibles"
                    txtNomb3.text = "No hay datos disponibles"
                    txtNomb4.text = "No hay datos disponibles"
                    txtPeso1.text = "No hay datos disponibles"
                    txtPeso2.text = "No hay datos disponibles"
                    txtPeso3.text = "No hay datos disponibles"
                    txtPeso4.text = "No hay datos disponibles"
                    txtRep1.text = "No hay datos disponibles"
                    txtRep2.text = "No hay datos disponibles"
                    txtRep3.text = "No hay datos disponibles"
                    txtRep4.text = "No hay datos disponibles"
                    txtSeries1.text = "No hay datos disponibles"
                    txtSeries2.text = "No hay datos disponibles"
                    txtSeries3.text = "No hay datos disponibles"
                    txtSeries4.text = "No hay datos disponibles"
        }
                val buttonVolver : Button = findViewById(R.id.btnVolver6)
                buttonVolver.setOnClickListener {
                    val intent = Intent (this, HomeActivity :: class.java) //Irá a la activity 5
                    startActivity(intent)
                }
            }
        }

    }
}
