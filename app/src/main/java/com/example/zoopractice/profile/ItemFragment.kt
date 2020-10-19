package com.example.zoopractice.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.zoopractice.R
import com.example.zoopractice.databinding.FragItemBinding

class ItemFragment: Fragment() {

    private lateinit var binding: FragItemBinding
    private val shareVm by activityViewModels<ShareViewModel>()
    private var tab: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("${this.tag} $tab onCreateView")
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_item, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("${this.tag} $tab onViewCreated")
    }

    override fun onResume() {
        super.onResume()
        shareVm.setFragTag(tab, this.tag)
        println("${this.tag} $tab onResume")
    }

    override fun onPause() {
        super.onPause()
        println("${this.tag} $tab onPause")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        println("${this.tag} $tab onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("${this.tag} $tab onDestroy")
    }

    fun setText(text: String) {
        binding.tag.text = text
    }

    companion object {
        fun newInstance(tab: String): ItemFragment {
            return ItemFragment().apply {
                this.tab = tab
            }
        }
    }
}