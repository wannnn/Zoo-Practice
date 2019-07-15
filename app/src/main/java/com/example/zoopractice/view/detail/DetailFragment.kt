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

    companion object {
        fun newInstance() = DetailFragment()
    }

    private val viewModel: DetailViewModel by lazy {
        ViewModelProviders.of(this).get(DetailViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragDetailBinding>(inflater, R.layout.frag_detail, container, false)

        binding.apply {
            results = arguments?.getParcelable("data")
            lifecycleOwner = this@DetailFragment
            viewModel = this@DetailFragment.viewModel
            executePendingBindings()

            val title = results?.name
            title?.let {
                (activity as MainActivity).updateToolbar(it)
            }
        }

        return binding.root
    }
}