package com.example.zoopractice.viewmodel

import androidx.lifecycle.ViewModel
import com.example.zoopractice.repository.ZooRepository

class DetailViewModel  : ViewModel() {

    private val repository: ZooRepository = ZooRepository()

}