package com.example.zoopractice.profile

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.example.zoopractice.R
import com.example.zoopractice.databinding.FragProfileBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment() {

    private lateinit var binding: FragProfileBinding
    private val shareVm by activityViewModels<ShareViewModel>()
    private val pagerAdapter: ViewPagerAdapter by lazy { ViewPagerAdapter(requireActivity()) }

    private val tabs = listOf("A", "B", "C", "D", "E", "F", "G")
    private var itemFrag: ItemFragment? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_profile, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.tabLayout) {
            setUnboundedRipple(true)
            addOnTabSelectedListener(tabSelectedListener)
        }

        with(binding.viewPager) {
            adapter = pagerAdapter
            offscreenPageLimit = 1
            pagerAdapter.setData(tabs)

            registerOnPageChangeCallback(
                object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
//                        itemFrag?.setText("Call $position API!!!")
                    }
                }
            )

        }

        initTabs()
        observeVm()
    }

    private fun initTabs() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager, false) { tab, position ->
            tab.customView = TextView(context).apply {
                text = tabs[position]
                textSize = 17f
                gravity = Gravity.CENTER
                setTextColor(Color.BLACK)
            }
        }.attach()
    }

    private fun observeVm() {
        shareVm.fragTag.observe(viewLifecycleOwner, Observer {
            val(currentTab, fragTag) = it
            itemFrag = (requireActivity().supportFragmentManager.findFragmentByTag(fragTag) as? ItemFragment)
            itemFrag?.setText("Call $currentTab API!!!")
        })
    }

    private val tabSelectedListener: TabLayout.OnTabSelectedListener
        get() = object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                (tab.customView as TextView).apply {
                    setTextColor(Color.BLACK)
                    typeface = Typeface.DEFAULT
                }
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                (tab.customView as TextView).apply {
                    setTextColor(context.getColor(R.color.colorPrimary))
                    typeface = Typeface.DEFAULT_BOLD
                }
            }
        }
}