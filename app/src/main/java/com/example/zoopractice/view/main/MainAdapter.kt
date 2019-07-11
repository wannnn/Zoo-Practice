package com.example.zoopractice.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zoopractice.R
import com.example.zoopractice.databinding.FragMainBinding
import com.example.zoopractice.model.AnimalResults



class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var animalResults: List<AnimalResults> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)

        return ViewHolder(view)
    }

//    override fun getItemCount(): Int = animalResults.size
    override fun getItemCount(): Int {
        return 5
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

//        val data = animalResults?.get(position)
//        holder.binding.setData(data)
    }

    fun updateData(list: List<AnimalResults>) {
        animalResults = list
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val binding: FragMainBinding? = null

        fun bind(data: AnimalResults) {



        }

    }

}