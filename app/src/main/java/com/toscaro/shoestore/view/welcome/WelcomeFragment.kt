package com.toscaro.shoestore.view.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.toscaro.shoestore.R
import com.toscaro.shoestore.databinding.FragmentWelcomeBinding
import com.toscaro.shoestore.view.common.BaseFragment

class WelcomeFragment : BaseFragment() {
    override val fragmentTitle: Int = R.string.welcome_screen_title

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