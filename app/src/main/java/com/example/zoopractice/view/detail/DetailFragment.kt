package com.example.zoopractice.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.Person.fromBundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.zoopractice.R
import com.example.zoopractice.databinding.FragDetailBinding
import com.example.zoopractice.viewmodel.DetailViewModel

class DetailFragment : Fragment()  {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private val viewModel: DetailViewModel by lazy {
        ViewModelProviders.of(this).get(DetailViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragDetailBinding>(inflater, R.layout.frag_detail, container, false)

//        arguments?.let {
//            val args = MainFragmentArgs.fromBundle(it)
//            binding.results = args.data
//            binding.lifecycleOwner = this
//        }

        if (arguments != null) {
            binding.results = arguments!!.getParcelable("data")
            binding.lifecycleOwner = this
            binding.executePendingBindings()
        }

        return binding.root
    }
}