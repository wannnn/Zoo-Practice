package com.example.zoopractice.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.zoopractice.R
import com.example.zoopractice.databinding.FragHelloBinding

class HelloFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragHelloBinding>(inflater, R.layout.frag_hello, container, false)

        return binding.root
    }
}