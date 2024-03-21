package com.example.gitasoulbhagavadgita.repository

import com.example.gitasoulbhagavadgita.datasource.ApiUtilities
import com.example.gitasoulbhagavadgita.models.ChaptersItem
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KrishnaRepository {


    fun getAllChapter() : Flow<List<ChaptersItem>> = callbackFlow {
        val callback = object : Callback<List<ChaptersItem>>{
            override fun onResponse(
                call: Call<List<ChaptersItem>>,
                response: Response<List<ChaptersItem>>
            ) {
                if (response.isSuccessful && response.body() != null){
                    trySend(response.body()!!)
                    close()
                }

            }
            override fun onFailure(call: Call<List<ChaptersItem>>, t: Throwable) {
                close(t)
            }

        }

        ApiUtilities.api.getAllChapter().enqueue(callback)

        awaitClose()
    }
}