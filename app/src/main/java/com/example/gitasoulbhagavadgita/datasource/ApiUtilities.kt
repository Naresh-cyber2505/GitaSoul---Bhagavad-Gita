package com.example.gitasoulbhagavadgita.datasource

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilities {

    val api : KrishnaApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://bhagavad-gita3.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KrishnaApi::class.java)
    }
}