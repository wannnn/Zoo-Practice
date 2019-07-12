package com.example.zoopractice.api

import com.example.zoopractice.model.ServerResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("apiAccess?")
    fun getZoo(@Query("scope") scope: String, @Query("rid") id: String): Observable<ServerResponse>

}