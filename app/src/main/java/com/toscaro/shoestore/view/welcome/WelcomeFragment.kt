package com.toscaro.shoestore.view.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.toscaro.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentWelcomeBinding.inflate(inflater, container, false)

        binding.welcomeHowToUseButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()
            )
        )
        return binding.root
    }

}