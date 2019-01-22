package com.example.retrofitjobqueue

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServicioDeRecursos {

    @GET("resource/hma6-9xbg.json")
    fun solicitarListaRecursos(@Query("category") category: String, @Query("item") item: String): Call<List<ItemDto>>
}