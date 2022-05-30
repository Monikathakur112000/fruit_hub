package com.example.fruithub.fragment.orderlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fruithub.R
import com.example.fruithub.databinding.OrderListFragmentBinding


class OrderListFragment : Fragment() {


    private lateinit var binding: OrderListFragmentBinding

    private val viewModel: OrderListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        /*Inflate the layout to this fragment*/
        binding = OrderListFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*StatusBar Color Change*/
        activity?.getColor(R.color.orange)?.let { activity?.window?.statusBarColor = it }
        onClick()
    }


    private fun onClick(){

        /*Navigation From OrderList To HomeScreen*/
        binding.goBackCardView.setOnClickListener {
            findNavController().navigate(R.id.action_orderListFragment_to_homeScreenFragment)
        }
    }

}