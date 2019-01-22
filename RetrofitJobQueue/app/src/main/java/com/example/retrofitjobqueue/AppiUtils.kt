package com.example.retrofitjobqueue

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppiUtils {

    companion object {
        private fun generarOKHttpBuilder(): OkHttpClient{
            return OkHttpClient().newBuilder().build()
        }

        fun generarInstanciaRetrofit(): Retrofit{

            return Retrofit.Builder()
                .baseUrl(ConstanteEndPoint.ENDPOINT)
                .client(generarOKHttpBuilder())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}