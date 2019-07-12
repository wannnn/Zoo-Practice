package com.example.zoopractice.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.zoopractice.BR
import com.example.zoopractice.R
import com.example.zoopractice.databinding.ItemAnimalBinding
import com.example.zoopractice.model.Results


class MainAdapter : RecyclerView.Adapter<MainAdapter.ItemHolder>() {

    private var resultsList: List<Results> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding = DataBindingUtil.inflate<ItemAnimalBinding>(LayoutInflater.from(parent.context), R.layout.item_animal, parent, false)


        return ItemHolder(binding)
    }

    override fun getItemCount(): Int = resultsList.size


    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        holder.bind(resultsList[position])
    }

    fun setData(list: List<Results>) {
        resultsList = list
        notifyDataSetChanged()
    }


    class ItemHolder (private val binding: ItemAnimalBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(data: Results) {
            binding.apply {
                setVariable(BR.results, data)
                executePendingBindings()
            }
        }

    }

//    @BindingAdapter({"imgUrl"})
//    fun loadImage(imageView: ImageView, url: String) {
//        Glide.with(this)
//            .load(url)
//            .into(imageView)
//    }

}
