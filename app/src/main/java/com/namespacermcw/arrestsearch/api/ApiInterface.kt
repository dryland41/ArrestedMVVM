package com.namespacermcw.arrestsearch.api

import com.namespacermcw.arrestsearch.model.JailHouse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/api/1/search/")
    fun getRecords(
        @Query("source_id") sourceId: String,
        @Query("last_name") name: String
    ): Call<JailHouse>
}