package com.example.zoopractice.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zoopractice.model.AnimalResults
import com.example.zoopractice.repository.AnimalRepository

class MainViewModel : ViewModel() {

    private val repository: AnimalRepository = AnimalRepository()

    val test = "123"

    fun getZooData() : MutableLiveData<List<AnimalResults>> {
        return repository.getZooData()
    }

//    val items: MutableLiveData<List<AnimalResults>> =
//        MutableLiveData<List<AnimalResults>>().apply {
//            value = AnimalRepository().getAnimalData()
//        }

}
