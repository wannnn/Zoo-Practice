package com.example.zoopractice.profile

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {

    private val itemIds = mutableSetOf<Long>()
    private var tabs: List<String> = listOf()

    override fun getItemCount(): Int = tabs.size

    override fun getItemId(position: Int): Long = tabs[position].hashCode().toLong().also { itemIds.add(it) }

    override fun containsItem(itemId: Long): Boolean = itemIds.contains(itemId)

    override fun createFragment(position: Int): Fragment = ItemFragment.newInstance(tabs[position])

    fun setData(list: List<String>) {
        tabs = list
        notifyDataSetChanged()
    }

}