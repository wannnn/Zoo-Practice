package com.example.zoopractice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zoopractice.model.AnimalResults
import com.example.zoopractice.repository.AnimalRepository

class MainViewModel : ViewModel() {

    private val animalRepository: AnimalRepository = AnimalRepository()

    val test = "123"

    fun getAnimalData() : MutableLiveData<List<AnimalResults>> {
        return animalRepository.getAnimalData()
    }

//    val items: MutableLiveData<List<AnimalResults>> =
//        MutableLiveData<List<AnimalResults>>().apply {
//            value = AnimalRepository().getAnimalData()
//        }

}
