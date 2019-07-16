package com.example.zoopractice.view.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zoopractice.R
import com.example.zoopractice.viewmodel.MainViewModel
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.zoopractice.databinding.FragMainBinding
import com.example.zoopractice.model.Results


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var adapter: MainAdapter

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragMainBinding>(inflater, R.layout.frag_main, container, false)

        binding.recyclerAnimal.apply {
            layoutManager = LinearLayoutManager(context)
            this@MainFragment.adapter = MainAdapter(viewModel)
            adapter = this@MainFragment.adapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            hasFixedSize()
        }

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        observeViewModel(viewModel)
    }


    private fun observeViewModel(viewModel: MainViewModel) {
        // Update the list when the data changes
        viewModel.items.observe(this,
            Observer<List<Results>> { results ->
                if (results != null) {
                    adapter.setData(results)
                    Log.d("TAG", "Results$results")
                    Log.d("TAG", "Results" + results.size)
                }
            })
    }

}
