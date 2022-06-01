package com.example.fruithub.fragment.home.tabfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fruithub.R
import com.example.fruithub.data.HomeFragmentDataClass
import com.example.fruithub.databinding.TabItemViewBinding
import com.example.fruithub.fragment.home.adapter.HomeTabAdapter

class HottestTab : Fragment() {

    private lateinit var binding: TabItemViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,

        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        binding = TabItemViewBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeScreenRecyclerView3.adapter = HomeTabAdapter(context ?: return, tabScreen())
    }


    private fun tabScreen(): List<HomeFragmentDataClass> {
        return listOf(
            HomeFragmentDataClass(
                R.string.quinoaFruitSalad,
                R.drawable.quinoa_fruit_salad,
                R.string.amount
            ),
            HomeFragmentDataClass(
                R.string.tropicalFruitSalad,
                R.drawable.tropical_fruit_salad,
                R.string.amount
            ),
            HomeFragmentDataClass(
                R.string.melonFruitSalad,
                R.drawable.melon_fruit_salad,
                R.string.amount
            )
        )
    }

}


