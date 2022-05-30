package com.example.fruithub.fragment.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fruithub.R
import com.example.fruithub.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private val viewModel: WelcomeViewModel by viewModels()

    private lateinit var binding: FragmentWelcomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        /*Inflate The Layout*/
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner=viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Change StatusBar Color*/
        activity?.getColor(R.color.sunshade)?.let { activity?.window?.statusBarColor = it }
        onClick()
    }

    private fun onClick() {
        binding.welcomeScreenButton.setOnClickListener {

            /*Navigation From Welcome Screen To Authentication Screen*/
            findNavController().navigate(R.id.action_welcomeScreenFragment_to_authenticationScreenFragment)
        }

    }


}