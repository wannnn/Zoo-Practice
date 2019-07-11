package com.example.zoopractice.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.zoopractice.api.ApiInterface
import com.example.zoopractice.api.RetrofitClient
import com.example.zoopractice.model.AnimalResults
import com.example.zoopractice.model.ServerResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AnimalRepository {

    private val list: MutableList<AnimalResults> = mutableListOf()
    private val liveData = MutableLiveData<List<AnimalResults>>()
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        liveData.value = list
    }

    fun getZooData(): MutableLiveData<List<AnimalResults>> {
        var observable: Observable<ServerResponse> = RetrofitClient.getInstance.create(ApiInterface::class.java).getAnimal()
        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                    response -> response.result?.animalResults?.forEach { animalResults -> addList(animalResults?: AnimalResults()) }
            }.let {
                compositeDisposable.add(it)
            }

        return liveData
    }

    private fun addList(animalResults: AnimalResults) {
        list.add(animalResults)
        liveData.value = list
        Log.d("TAG", "ResultsInRepo$animalResults")
    }


//    private val list: MutableList<AnimalResults> = mutableListOf()
//    private var animalList: MutableLiveData<List<AnimalResults>>? = null
//
//    fun getDataFromServer() : MutableLiveData<List<AnimalResults>> {
//        if (animalList == null){
//            animalList = MutableLiveData()
//            getAnimalList()
//        }
//        return animalList as MutableLiveData<List<AnimalResults>>
//    }
//
//
//    private fun getAnimalList() {
//        var observable: Observable<ServerResponse> = RetrofitClient.getInstance.create(ApiInterface::class.java).getAnimal()
//        observable
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe { response ->
//                response.result?.animalResults?.forEach { animalresults ->
//                    addList(animalresults ?: AnimalResults())
//                }
//
//            }
//
//    }
//
//    private fun addList(animalResults: AnimalResults) {
//        list.add(animalResults)
//        animalList?.value = list
//    }
}


