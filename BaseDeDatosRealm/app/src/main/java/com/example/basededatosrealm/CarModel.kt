package com.example.basededatosrealm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class CarModel(@PrimaryKey var id: String = "", var brand: String = "") : RealmObject()