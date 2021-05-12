package com.namespacermcw.arrestsearch.api

import com.namespacermcw.arrestsearch.model.JailHouse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("search/")
    fun getRecords(
        @Query("source_id") sourceId: String,
        @Query("last_name") name: String
    ): Call<JailHouse>

    @GET("recent/")
    fun getRecents(
        @Query("source_id") source_id: String = "ga-fcso"
    ): Single<JailHouse>
}