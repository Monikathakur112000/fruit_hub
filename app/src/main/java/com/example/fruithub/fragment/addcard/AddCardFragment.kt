package com.example.fruithub.fragment.addcard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fruithub.R
import com.example.fruithub.databinding.AddCardFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddCardFragment : BottomSheetDialogFragment() {

  private lateinit var binding:AddCardFragmentBinding

    private val viewModel: AddCardViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        /* Inflate the layout for this fragment */
        binding = AddCardFragmentBinding.inflate(inflater,container,false)
        binding.viewModel=viewModel
        binding.lifecycleOwner=viewLifecycleOwner
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*Changing StatusBar Color To White*/
        activity?.getColor(R.color.orange)?.let { activity?.window?.statusBarColor = it }
        onClick()
    }

    private fun onClick(){

        /* Navigating from AddCard to Order Complete*/
        binding.completeOrder.setOnClickListener{
            findNavController().navigate(R.id.action_addCardFragment_to_orderCompleteFragment)
        }

        /* Navigating To Delivery Detail BottomSheet*/
        binding.crossCardView.setOnClickListener {
            dismiss()
            findNavController().navigate(R.id.action_addCardFragment_to_homeScreenFragment)
        }
    }

}