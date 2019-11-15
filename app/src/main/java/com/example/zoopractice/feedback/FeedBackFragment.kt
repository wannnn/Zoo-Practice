package com.example.zoopractice.feedback

import android.os.Bundle
import android.text.TextUtils
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

        // test 指令 -> adb shell am start -a android.intent.action.VIEW -d "http://www.ZooWebsite/Claire"
        val bundle = arguments
        if (bundle != null) {
            val params = bundle.getString("params")
            if (!TextUtils.isEmpty(params)) {
                binding.tvSendFeedback.text = "Send us feedBack from $params"
            }
        }

        return binding.root
    }
}