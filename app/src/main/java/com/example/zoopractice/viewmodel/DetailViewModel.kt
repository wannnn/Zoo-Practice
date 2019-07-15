package com.example.zoopractice.viewmodel

import androidx.lifecycle.ViewModel
import android.content.Intent
import android.net.Uri
import android.view.View


class DetailViewModel  : ViewModel() {

    fun openWeb(view: View, url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        view.context.startActivity(intent)
    }

}