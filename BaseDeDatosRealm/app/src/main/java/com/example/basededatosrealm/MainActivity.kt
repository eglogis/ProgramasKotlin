package com.example.basededatosrealm

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import io.realm.Realm
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var adapter = AdaptadorCoche(listOf(), {})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainList.layoutManager = LinearLayoutManager(this)
        adapter = AdaptadorCoche(getListaCoches(Realm.getDefaultInstance())) {

        }

        mainBtn.setOnClickListener{
            val intent = Intent(this, crearCoche::class.java)
            startActivity(intent)
        }
    }

    private fun getListaCoches(realm :Realm): List<CarModel>{
        return realm.where<CarModel>().findAll().toList()
    }
}
