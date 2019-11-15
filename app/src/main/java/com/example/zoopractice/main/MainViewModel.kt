package com.example.zoopractice.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.zoopractice.model.Results
import com.example.zoopractice.repository.ZooRepository

class MainViewModel : ViewModel() {

    private val repository: ZooRepository = ZooRepository()

    val items: LiveData<List<Results>> = repository.getZooData()

}
