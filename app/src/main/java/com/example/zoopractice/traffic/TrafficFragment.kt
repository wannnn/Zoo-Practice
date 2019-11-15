package com.example.zoopractice.traffic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.zoopractice.R
import com.example.zoopractice.databinding.FragTrafficBinding

class TrafficFragment : Fragment() {

    private lateinit var binding: FragTrafficBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_traffic, container, false)

        return binding.root
    }
}