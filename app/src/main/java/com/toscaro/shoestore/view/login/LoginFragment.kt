package com.toscaro.shoestore.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.toscaro.shoestore.R
import com.toscaro.shoestore.databinding.FragmentLoginBinding
import com.toscaro.shoestore.view.common.BaseFragment

class LoginFragment : BaseFragment() {

    override val fragmentTitle: Int = R.string.login_screen_title

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.registerButton.setOnClickListener {
            //TODO Implement when add Welcome Screen
        }
        binding.loginWithExistingAccountButton.setOnClickListener {
            //TODO Implement when add Welcome Screen
        }
        return binding.root
    }
}