package com.example.zoopractice.api

import com.example.zoopractice.model.Animal
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("rid={id}")
    fun getAnimal(@Path("id") id: String): Observable<Animal>
}