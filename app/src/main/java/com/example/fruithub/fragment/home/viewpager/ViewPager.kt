package com.example.fruithub.fragment.home.viewpager

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fruithub.fragment.home.tabfragment.HottestTab
import com.google.android.material.tabs.TabLayout


class ViewPager(supportFragmentManager: FragmentManager, lifecycle: Lifecycle) :
FragmentStateAdapter(supportFragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HottestTab()
            1 -> HottestTab()
            else -> {
             HottestTab()
            }
        }
    }

}
