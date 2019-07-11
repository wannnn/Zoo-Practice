package com.example.zoopractice.repository

import androidx.lifecycle.MutableLiveData
import com.example.zoopractice.api.ApiInterface
import com.example.zoopractice.api.RetrofitClient
import com.example.zoopractice.model.AnimalResults
import com.example.zoopractice.model.ServerResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AnimalRepository {

    private val animalList: MutableList<AnimalResults> = mutableListOf()
    private val animalLiveData: MutableLiveData<List<AnimalResults>> = MutableLiveData()

    init {
        animalLiveData.value = animalList
    }

    fun getAnimalData(): MutableLiveData<List<AnimalResults>> {
        var observable: Observable<ServerResponse> = RetrofitClient.getInstance.create(ApiInterface::class.java).getAnimal("5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a")
        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                    response -> response.result?.animalResults?.forEach { animalresults -> addList(animalresults?: AnimalResults()) }
            }

        return animalLiveData
    }

    private fun addList(animalresults: AnimalResults) {
        animalList.add(animalresults)
        animalLiveData.value = animalList
    }

}