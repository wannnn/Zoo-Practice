package com.example.zoopractice.api

import com.example.zoopractice.model.ServerResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("apiAccess?scope=resourceAquire&rid={id}")
    fun getAnimal(@Path("id") id: String): Observable<ServerResponse>
}