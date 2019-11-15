package com.example.zoopractice.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zoopractice.R
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.zoopractice.databinding.FragMainBinding
import com.example.zoopractice.model.Results
import timber.log.Timber


class MainFragment : Fragment() {

    private lateinit var adapter: MainAdapter

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragMainBinding>(inflater, R.layout.frag_main, container, false)

        binding.recyclerAnimal.apply {
            layoutManager = LinearLayoutManager(context)
            this@MainFragment.adapter = MainAdapter(viewModel, this@MainFragment)
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
        viewModel.items.observe(this, Observer<List<Results>> { results ->
                if (results != null) {
                    adapter.setData(results)
                    Timber.i("results$results")
                    Timber.i("results size${results.size}")
                }
            })
    }

    fun click(results: Results) {
//      方法一：use bundle
//        val bundle = Bundle()
//        bundle.putParcelable("data", results)
//        findNavController().navigate(R.id.action_mainFragment_to_detailFragment, bundle)

//      方法二：use argument
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(results))
    }

}
