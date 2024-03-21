package com.example.gitasoulbhagavadgita.datasource

import com.example.gitasoulbhagavadgita.models.ChaptersItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface KrishnaApi {


    @Headers(
        "Accept: application/json",
        "X-RapidAPI-Key: 8b3c682717msh7e36b8558b4e03cp1f30eajsn5a81cdd2c5e8",
        "X-RapidAPI-Host: bhagavad-gita3.p.rapidapi.com"
    )

    @GET("/v2/chapters/")
    fun getAllChapter() : Call<List<ChaptersItem>>

}