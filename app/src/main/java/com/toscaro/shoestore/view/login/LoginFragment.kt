package com.toscaro.shoestore.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.toscaro.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        val navigateToWelcomeClickListener = Navigation.createNavigateOnClickListener(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())

        binding.registerButton.setOnClickListener(navigateToWelcomeClickListener)
        binding.loginWithExistingAccountButton.setOnClickListener(navigateToWelcomeClickListener)
        return binding.root
    }
}