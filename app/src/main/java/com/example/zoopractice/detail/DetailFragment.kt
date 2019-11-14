package com.example.zoopractice.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.zoopractice.R
import com.example.zoopractice.databinding.FragDetailBinding
import com.example.zoopractice.view.MainActivity
import com.example.zoopractice.viewmodel.DetailViewModel

class DetailFragment : Fragment()  {

    private val viewModel: DetailViewModel by lazy {
        ViewModelProviders.of(this).get(DetailViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragDetailBinding>(inflater, R.layout.frag_detail, container, false)

        val bundle = arguments

        binding.apply {
//          方法一：receives arguments from bundle
//            results = arguments?.getParcelable("data")

            results = arguments?.let { DetailFragmentArgs.fromBundle(it).data }
            lifecycleOwner = this@DetailFragment
            viewModel = this@DetailFragment.viewModel
            executePendingBindings()

            val title = results?.name
            title?.let {
                (activity as MainActivity).updateToolbar(it)
            }

            // test 指令 -> adb shell am start -a android.intent.action.VIEW -d "http://www.zoo.gov.tw/introduce/gq.aspx?tid=13"
            if (bundle != null) {
                val params = bundle.getString("params")
                binding.fromWhere.text = params
            }
        }

        return binding.root
    }
}