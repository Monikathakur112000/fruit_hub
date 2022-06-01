package com.example.fruithub.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fruithub.R
import com.example.fruithub.data.HomeFragmentDataClass
import com.example.fruithub.databinding.FragmentHomeBinding
import com.example.fruithub.fragment.home.adapter.HomeRecommendedAdapter
import com.example.fruithub.fragment.home.adapter.HomeScreenAdapter
import com.example.fruithub.fragment.home.viewpager.ViewPager
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Changing StatusBar Color To White */
        activity?.getColor(R.color.white)?.let { activity?.window?.statusBarColor = it }
        initView()
        onClick()

    }

    private fun onClick() {

        /* Navigation From HomeScreen to OrderList*/
        binding.homeScreenImageView.setOnClickListener {
            findNavController().navigate(R.id.action_homeScreenFragment_to_orderListFragment)
        }

        /*Navigation From HomeScreen To MyBasket*/
        binding.homeCardView.setOnClickListener {
            findNavController().navigate(R.id.action_homeScreenFragment_to_myBasket)
        }

    }

    private fun recommend(): List<HomeFragmentDataClass> {
        return listOf(
            HomeFragmentDataClass(
                R.string.honeyLimeCombo,
                R.drawable.honey_limbo_combo_image,
                R.string.comboAmount
            ),
            HomeFragmentDataClass(
                R.string.berryCombo,
                R.drawable.berry_mango_combo_image,
                R.string.comboAmount
            ),
            HomeFragmentDataClass(
                R.string.tropicalFruitSalad,
                R.drawable.tropical_fruit_salad,
                R.string.amount
            ),
            HomeFragmentDataClass(
                R.string.quinoaFruitSalad,
                R.drawable.quinoa_fruit_salad,
                R.string.amount
            )

        )
    }

    private fun initView() {
        binding.homeScreenRecyclerView1.adapter = HomeScreenAdapter(context ?: return)

        binding.homeScreenRecyclerView2.adapter =
            HomeRecommendedAdapter(context ?: return, recommend())

        binding.viewPager.adapter = ViewPager(childFragmentManager, lifecycle)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->

            when (position) {
                0 -> tab.setText(R.string.hottestTab)
                1 -> tab.setText(R.string.popularTab)
                else -> {
                    tab.setText(R.string.newComboTab)
                }
            }
        }.attach()

    }
}

