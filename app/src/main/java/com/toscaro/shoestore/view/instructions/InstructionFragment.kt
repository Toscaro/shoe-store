package com.toscaro.shoestore.view.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.toscaro.shoestore.R
import com.toscaro.shoestore.databinding.FragmentInstructionBinding
import com.toscaro.shoestore.view.common.BaseFragment

class InstructionFragment : BaseFragment() {
    override val fragmentTitle: Int = R.string.instruction_screen_title

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentInstructionBinding.inflate(inflater, container, false)

        binding.continueButton.setOnClickListener {
            //TODO add navigation when implement the Shoe List Screen
        }
        return binding.root
    }

}