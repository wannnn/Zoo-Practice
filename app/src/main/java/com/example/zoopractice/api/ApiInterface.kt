package com.example.zoopractice.api

import com.example.zoopractice.model.ServerResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

//    @GET("apiAccess?scope=resourceAquire&rid={id}")
//    fun getAnimal(@Path("id") id: String): Observable<ServerResponse>
//    @GET("apiAccess?")
//    fun getAnimal(@Query("scope") scope: String, @Query("rid") id: String): Observable<ServerResponse>
        @GET("apiAccess?scope=resourceAquire&rid=5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a")
        fun getAnimal(): Observable<ServerResponse>
}