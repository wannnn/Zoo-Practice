package com.example.zoopractice.feedback

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.zoopractice.R
import com.example.zoopractice.databinding.FragFeedbackBinding

class FeedBackFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragFeedbackBinding>(inflater, R.layout.frag_feedback, container, false)


        return binding.root
    }
}