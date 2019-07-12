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
import com.example.zoopractice.viewmodel.MainViewModel
import androidx.lifecycle.Observer
import com.example.zoopractice.databinding.FragMainBinding
import com.example.zoopractice.model.Results


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragMainBinding
    private lateinit var viewModel: MainViewModel
    private var mAdapter: MainAdapter = MainAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragMainBinding.bind(inflater.inflate(R.layout.frag_main, container, false)).apply {
            this.lifecycleOwner = this@MainFragment
            this.recyclerAnimal.apply {
                layoutManager = LinearLayoutManager(context)
                hasFixedSize()
            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // ViewModel
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)


        observeViewModel(viewModel)
    }


    private fun observeViewModel(viewModel: MainViewModel) {
        // Update the list when the data changes
        viewModel.items.observe(this,
            Observer<List<Results>> { results ->
                if (results != null) {
                    mAdapter.setData(results)
                    Log.d("TAG", "Results$results")
                    Log.d("TAG", "Results" + results.size)
                }
            })
    }

}
