package com.example.zoopractice.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.zoopractice.R
import com.example.zoopractice.model.Results
import com.example.zoopractice.repository.ZooRepository

class MainViewModel : ViewModel() {

    private val repository: ZooRepository = ZooRepository()


    fun click(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_detailFragment)
    }

    val items: MutableLiveData<List<Results>> = repository.getZooData()

}
