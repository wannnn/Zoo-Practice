package com.example.zoopractice.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel : ViewModel() {

    private val _fragTag = MutableLiveData<Pair<String, String>>()
    val fragTag: LiveData<Pair<String, String>> = _fragTag


    fun setFragTag(currentTab: String, tag: String?) {
        _fragTag.value = Pair(currentTab, tag.orEmpty())
    }
}