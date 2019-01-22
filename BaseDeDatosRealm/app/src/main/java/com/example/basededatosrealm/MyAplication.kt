package com.example.basededatosrealm

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyAplication: Application(){

    override fun onCreate() {
        super.onCreate()
        setupRealm()
    }

    fun setupRealm() {
        Realm.init(this)

        val config = RealmConfiguration.Builder()
            .name("coches.realm")
            .build()
        Realm.setDefaultConfiguration(config)
    }
}