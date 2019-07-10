package com.example.zoopractice.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zoopractice.R
import com.example.zoopractice.model.AnimalResults

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var animalResults: List<AnimalResults>? = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun updateData() {

        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var mainImg: ImageView = itemView.findViewById(R.id.animal_img)
        var title: TextView = itemView.findViewById(R.id.animal_title)
        var info: TextView = itemView.findViewById(R.id.animal_info)
        var memo: TextView = itemView.findViewById(R.id.animal_memo)
        var detailBtn: ImageButton = itemView.findViewById(R.id.img_btn_arrow)

    }

}