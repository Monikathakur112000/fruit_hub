package com.example.fruithub.fragment.ordercomplete


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fruithub.R
import com.example.fruithub.databinding.OrderCompleteFragmentBinding

class OrderCompleteFragment : Fragment() {


    private val viewModel: OrderCompleteViewModel by viewModels()

    private lateinit var binding: OrderCompleteFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OrderCompleteFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*StatusBar Color Change*/
        activity?.getColor(R.color.white)?.let { activity?.window?.statusBarColor = it }
        setAnimation()
        onClick()
    }

    private fun onClick() {

        /*Navigation From OrderComplete To OrderList*/
        binding.trackOrderButton.setOnClickListener {
            findNavController().navigate(R.id.action_orderCompleteFragment_to_orderListFragment)
        }

        /*Navigation From OrderComplete To HomeScreen*/
        binding.continueButton.setOnClickListener {
            findNavController().navigate(R.id.action_orderCompleteFragment_to_homeScreenFragment)
        }
    }


    /* Setting Animation*/
    private fun setAnimation() {

        val animation = AnimationUtils.loadAnimation(context, R.anim.order_complete_anim)
        binding.orderImageView.animation = animation

        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationRepeat(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {}


        })
    }
}