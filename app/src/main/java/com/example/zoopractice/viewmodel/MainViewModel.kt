package com.example.zoopractice.viewmodel

import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.zoopractice.R
import com.example.zoopractice.model.Results
import com.example.zoopractice.repository.ZooRepository
import com.example.zoopractice.view.main.MainFragmentDirections

class MainViewModel : ViewModel() {

    private val repository: ZooRepository = ZooRepository()

    val items: MutableLiveData<List<Results>> = repository.getZooData()

    fun click(view: View, results: Results) {
        val bundle = Bundle()
        bundle.putParcelable("data", results)
        Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_detailFragment, bundle)
    }

}
