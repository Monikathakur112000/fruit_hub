package com.example.fruithub.fragment.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fruithub.R
import com.example.fruithub.databinding.FragmentAuthenticationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthenticationFragment : Fragment() {

    private val viewModel: AuthenticationViewModel by viewModels()

    private lateinit var binding: FragmentAuthenticationBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        /* Inflate the layout for this fragment*/
        binding = FragmentAuthenticationBinding.inflate(inflater, container, false)
        binding.lifecycleOwner=viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*Setting The  StatusBar Color*/
        activity?.getColor(R.color.sunshade)?.let { activity?.window?.statusBarColor = it }
        onClick()
    }


    private fun onClick() {

        /*Navigation Form AuthenticationScreen TO HomeScreen*/
        binding.authenticationScreenButton.setOnClickListener {
            findNavController().navigate(R.id.action_authenticationScreenFragment_to_homeScreenFragment)
        }
    }
}