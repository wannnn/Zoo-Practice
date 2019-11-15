package com.example.zoopractice.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.zoopractice.R
import com.example.zoopractice.databinding.FragProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_profile, container, false)

        return binding.root
    }
}