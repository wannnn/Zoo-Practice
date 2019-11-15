package com.example.zoopractice.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.zoopractice.R
import com.example.zoopractice.model.Results
import com.example.zoopractice.repository.ZooRepository
import com.example.zoopractice.main.MainFragmentDirections

class MainViewModel : ViewModel() {

    private val repository: ZooRepository = ZooRepository()

    val items: LiveData<List<Results>> = repository.getZooData()

//    fun click(results: Results) {
////      方法一：use bundle
////        val bundle = Bundle()
////        bundle.putParcelable("data", results)
////        Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_detailFragment, bundle)
//
////      方法二：use argument
//        Navigation.findNavController(view).navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(results))
//    }

}
