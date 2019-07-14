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
import androidx.recyclerview.widget.RecyclerView
import com.example.zoopractice.model.Results


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var viewModel: MainViewModel
    private var mAdapter: MainAdapter = MainAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.frag_main, container, false)

        mRecyclerView = view.findViewById(R.id.recycler_animal)
                mRecyclerView.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = mAdapter
                    hasFixedSize()
                }

        return view

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
