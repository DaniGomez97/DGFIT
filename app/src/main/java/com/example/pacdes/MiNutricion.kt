package com.example.pacdes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MiNutricion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_nutricion)

        //Creamos variable para el UID y la Base de Datos
        val db : FirebaseFirestore = FirebaseFirestore.getInstance()
        val mAuth: FirebaseAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser

        //Ahora los textview donde veremos la info
        val txtDatosMetabolismoAct : TextView = findViewById(R.id.txtDatosMetabolismoAct)
        val txtDatosMetabolismoTra : TextView = findViewById(R.id.txtDatosMetabolismoTranq)

        val txtDatosAdelgazarAct : TextView = findViewById(R.id.txtDatosAdelgazarAct)
        val txtDatosAdelgazarTra : TextView = findViewById(R.id.txtDatosAdelgazarTranq)

        val txtDatosMantAct : TextView = findViewById(R.id.txtDatosMantAct)
        val txtDatosMantTra : TextView = findViewById(R.id.txtDatosMantTranq)

        val txtDatosVolumenAct : TextView = findViewById(R.id.txtDatosVolumenAct)
        val txtDatosVolumenTra  : TextView = findViewById(R.id.txtDatosVolumenTranq)

        //Si el usuario no es null
        if (currentUser != null) {
            val userId = currentUser.uid //Obtén su referencia
            val docRef = db.collection("Nutricion").document(userId)   //Busca en la db la coleccion "Nutricio" con el documento referente al ID del user
            docRef.get().addOnSuccessListener{document->
                if (document != null && document.exists()){

                    //Obtenemos los datos de cada campo de la BD y lo ponemos en los TextView

                    //METABOLISMO BASAL
                    val kcalMetBasAct= document.getDouble("metab_act")
                    txtDatosMetabolismoAct.text = kcalMetBasAct.toString()

                    val kcalMetBasTra= document.getDouble("metab_tra")
                    txtDatosMetabolismoTra.text = kcalMetBasTra.toString()

                    //ADELGAZAR
                    val kcalAdelAct = document.getDouble("kcal_adel_act")
                    txtDatosAdelgazarAct.text = kcalAdelAct.toString()

                    val kcalAdelTra = document.getDouble("kcal_adel_tra")
                    txtDatosAdelgazarTra.text = kcalAdelTra.toString()

                    //VOLUMEN
                    val kcalVolumenAct = document.getDouble("kcal_vol_act")
                    txtDatosVolumenAct.text = kcalVolumenAct.toString()

                    val kcalVolumenTra = document.getDouble("kcal_vol_tra")
                    txtDatosVolumenTra.text = kcalVolumenTra.toString()

                    //MANTENIMIENTO
                    val kcalMantTra= document.getDouble("kcal_mant_tra")
                    txtDatosMantTra.text = kcalMantTra.toString()

                    val kcalMantAct = document.getDouble("kcal_mant_act")
                    txtDatosMantAct.text = kcalMantAct.toString()
                }
                else{ //Si no, muestra el mensaje de: "No hay datos disponibles"
                    txtDatosMantAct.text = "No hay datos disponibles"
                    txtDatosMantTra.text = "No hay datos disponibles"
                    txtDatosAdelgazarAct.text = "No hay datos disponibles"
                    txtDatosAdelgazarTra.text = "No hay datos disponibles"
                    txtDatosMetabolismoAct.text = "No hay datos disponibles"
                    txtDatosMetabolismoTra.text = "No hay datos disponibles"
                    txtDatosVolumenAct.text = "No hay datos disponibles"
                    txtDatosVolumenTra.text = "No hay datos disponibles"
                }

        val buttonVolver : Button = findViewById(R.id.btnVolver7)
        buttonVolver.setOnClickListener {
            val intent = Intent (this, HomeActivity::class.java)
            startActivity(intent)
                 }
             }
        }
    }
}