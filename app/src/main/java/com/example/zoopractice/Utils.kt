package com.example.zoopractice

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object Utils {

    @BindingAdapter("imageUrl")
    fun loadImage(imageView: ImageView, url: String?) {
        Glide.with(imageView.context).load(url).into(imageView)
    }

}