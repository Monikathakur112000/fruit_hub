package com.example.fruithub.fragment.splash

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
import com.example.fruithub.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        binding.lifecycleOwner=viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.getColor(R.color.white)?.let { activity?.window?.statusBarColor = it }
        setAnimation()

    }

    /* Set Animation */
    private fun setAnimation() {

        val animation = AnimationUtils.loadAnimation(context, R.anim.bounce)
        binding.splashImageView.animation = animation

        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationRepeat(animation: Animation) {}

            /*Navigating From Splash Screen To Welcome Screen*/
            override fun onAnimationEnd(animation: Animation) {
                findNavController().navigate(R.id.action_splashScreenFragment_to_welcomeScreenFragment)

            }
        })
    }

}



