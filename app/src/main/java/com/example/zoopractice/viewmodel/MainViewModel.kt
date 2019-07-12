package com.example.zoopractice.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zoopractice.model.Results
import com.example.zoopractice.repository.ZooRepository

class MainViewModel : ViewModel() {

    private val repository: ZooRepository = ZooRepository()


    fun getZooData() : MutableLiveData<List<Results>> {
        return repository.getZooData()
    }

    val items: MutableLiveData<List<Results>> = repository.getZooData()

}
