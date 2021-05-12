package com.namespacermcw.arrestsearch.api

import com.namespacermcw.arrestsearch.model.JailHouse
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val retrofit2= Retrofit.Builder()
        .baseUrl("https://www.jailbase.com/api/1/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    private val arrestServiceAPI: ApiInterface=retrofit2.create(ApiInterface::class.java)

    fun getRecentsObservable(): Single<JailHouse> {
        return arrestServiceAPI.getRecents()
    }

    companion object {

        private val client = OkHttpClient.Builder().build()

        private val retrofit = Retrofit.Builder()
            .baseUrl("https://www.jailbase.com/api/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        fun <T> buildService(service: Class<T>): T {
            return retrofit.create(service)
        }
    }

}