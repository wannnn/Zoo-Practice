package com.example.zoopractice

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object Utils {

//    @BindingAdapter("imageUrl")
//    fun loadImage(imageView: ImageView, url: String?) {
//        Glide.with(imageView.context).load(url).into(imageView)
//    }

}

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String?) {
//    val imgUri = url?.toUri()?.buildUpon()?.build()
    GlideApp.with(imageView.context)
        .load(url)
        .apply(
            RequestOptions()
                .placeholder(R.drawable.cat)
                .error(R.drawable.cat)
        )
        .into(imageView)
}