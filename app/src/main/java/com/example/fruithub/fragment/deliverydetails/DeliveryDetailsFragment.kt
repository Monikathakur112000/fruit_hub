package com.example.fruithub.fragment.deliverydetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fruithub.R
import com.example.fruithub.databinding.DeliveryDetailsFragmentBinding
import com.example.fruithub.fragment.addcard.AddCardFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DeliveryDetailsFragment : BottomSheetDialogFragment() {


    private val viewModel: DeliveryDetailsViewModel by viewModels()
    private lateinit var binding: DeliveryDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        /* Inflate the layout for this fragment */
        binding = DeliveryDetailsFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*StatusBar Color Change*/
        activity?.getColor(R.color.orange)?.let { activity?.window?.statusBarColor = it }
        onClick()
    }

    private fun onClick() {

        /* Navigation From DeliveryDetail To AddCard*/
        binding.payWithCardButton.setOnClickListener {
            val bottomSheetFragment: BottomSheetDialogFragment = AddCardFragment()
            bottomSheetFragment.show(childFragmentManager, "BottomSheet")

        }

        /*Navigation From DeliveryDetail To OrderComplete*/
        binding.payOnDeliveryButton.setOnClickListener {
            findNavController().navigate(R.id.action_deliveryDetailsFragment_to_orderCompleteFragment)
        }

        /*Navigation From DeliveryDetail To MyBasket*/
        binding.crossCardView.setOnClickListener {
            dismiss()
        }

    }


}