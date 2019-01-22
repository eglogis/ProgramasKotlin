package com.example.basededatosrealm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_crear_coche.*

class crearCoche : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_coche)

        createBtn.setOnClickListener{
            val text = createInput.text.toString()
            if(!TextUtils.isEmpty(text)){
                Realm.getDefaultInstance().executeTransaction{

                    crearCoche(it, text)
                }
                createInput.setText("")
                Toast.makeText(this, "Creado correctamente", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "El texto no puede ser vacio", Toast.LENGTH_SHORT).show()

            }
        }
    }

   private fun crearCoche(realm: Realm, text: String){
       realm.copyToRealmOrUpdate(CarModel(text, text))
   }
}
