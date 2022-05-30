package com.example.fruithub.fragment.addtobasket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fruithub.R
import com.example.fruithub.databinding.FragmentAddToBasketBinding
import com.google.android.flexbox.*


class AddToBasketFragment : Fragment() {

    private lateinit var binding: FragmentAddToBasketBinding
    private val viewModel: AddToBasketViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        /* Inflate the layout for this fragment*/
        binding = FragmentAddToBasketBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* StatusBar Color Change*/
        activity?.getColor(R.color.orange)?.let { activity?.window?.statusBarColor = it }
        binding.addToBasketRecyclerView.adapter = AddToBasketAdapter(context ?: return)

        /*Using FlexLayout To RecyclerView*/
        val layoutManager = FlexboxLayoutManager(context)
        layoutManager.flexWrap = FlexWrap.WRAP
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.FLEX_START
        layoutManager.alignItems = AlignItems.FLEX_START
        binding.addToBasketRecyclerView.layoutManager = layoutManager
        onClick()
    }

    private fun onClick() {

        /*Navigation From AddToBasket To HomeScreen*/
        binding.goBackCardView.setOnClickListener {
            findNavController().navigate(R.id.action_addToBasketFragment_to_homeScreenFragment)
        }

        /*Navigation From AddToBasket To MyBasket*/
        binding.addBasketButton.setOnClickListener {
            findNavController().navigate(R.id.action_addToBasketFragment_to_myBasket)
        }
    }


}