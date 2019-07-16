package com.example.zoopractice.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.zoopractice.R
import com.example.zoopractice.databinding.ItemAnimalBinding
import com.example.zoopractice.model.Results
import com.example.zoopractice.viewmodel.MainViewModel


class MainAdapter(private val mainViewModel: MainViewModel) : RecyclerView.Adapter<MainAdapter.ItemHolder>() {

    private var resultsList: List<Results> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding = DataBindingUtil.inflate<ItemAnimalBinding>(LayoutInflater.from(parent.context), R.layout.item_animal, parent, false)

        return ItemHolder(binding)
    }

    override fun getItemCount(): Int = resultsList.size


    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(resultsList[position], mainViewModel)
    }

    fun setData(list: List<Results>) {
        resultsList = list
        notifyDataSetChanged()
    }


    class ItemHolder (private val binding: ItemAnimalBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(data: Results, viewModel: MainViewModel) {
            viewModel.let {
                binding.results = data
                binding.viewModel = it
                binding.executePendingBindings()
                binding.invalidateAll()
            }
        }

    }
}
