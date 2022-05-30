package com.example.fruithub.fragment.mybasket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fruithub.R
import com.example.fruithub.data.HomeFragmentDataClass
import com.example.fruithub.databinding.FragmentMyBasketBinding
import com.example.fruithub.fragment.deliverydetails.DeliveryDetailsFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MyBasketFragment : Fragment() {

    private val viewModel: MyBasketViewModel by viewModels()

    private lateinit var binding: FragmentMyBasketBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        binding = FragmentMyBasketBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*StatusBar Color Change*/
        activity?.getColor(R.color.orange)?.let { activity?.window?.statusBarColor = it }
        binding.basketRecyclerView.adapter = MyBasketAdapter(context ?: return, tab())
        onClick()
    }

    private fun onClick() {

        /*Navigation From MyBasket To HomeScreen*/
        binding.goBackCardView.setOnClickListener {
            findNavController().navigate(R.id.action_myBasket_to_homeScreenFragment)
        }

        /*Navigation To DeliveryDetail BottomSheet*/
        binding.checkoutButton.setOnClickListener {
            val bottomSheetFragment: BottomSheetDialogFragment = DeliveryDetailsFragment()
            bottomSheetFragment.show(childFragmentManager,"BottomSheet")

        }
    }

    private fun tab(): List<HomeFragmentDataClass> {
        return listOf(

            HomeFragmentDataClass(
                R.string.tropicalFruitSalad,
                R.drawable.tropical_fruit_salad,
                R.string.basket_amount
            ),
            HomeFragmentDataClass(
                R.string.berryCombo,
                R.drawable.berry_mango_combo_image,
                R.string.basket_amount
            ), HomeFragmentDataClass(
                R.string.quinoaFruitSalad,
                R.drawable.quinoa_fruit_salad,
                R.string.basket_amount
            )


        )
    }
}
