package com.example.zoopractice.view.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zoopractice.R
import com.example.zoopractice.databinding.FragMainBinding
import com.example.zoopractice.viewmodel.MainViewModel
import androidx.lifecycle.Observer
import com.example.zoopractice.model.AnimalResults


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragMainBinding
    private var mAdapter: MainAdapter = MainAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.frag_main, container, false)
        binding = FragMainBinding.bind(root).apply {
            this.viewModel = viewModel
        }
        binding.lifecycleOwner = this


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // ViewModel
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        setUpView()
        observeViewModel(viewModel)

    }

    private fun setUpView() {
        binding.recyclerAnimal.apply {
            layoutManager = LinearLayoutManager(context)
            hasFixedSize()
            adapter = MainAdapter()
        }
    }

    private fun observeViewModel(viewModel: MainViewModel) {
        // Update the list when the data changes
        viewModel.getAnimalData().observe(this,
            Observer<List<AnimalResults>> { animalResults ->
                if (animalResults != null) {
//                    mAdapter.updateData(animalResults)
                    Log.d("TAG","Results" + animalResults)
                }
            })
    }

}
