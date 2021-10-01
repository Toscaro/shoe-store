package com.toscaro.shoestore.view.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.toscaro.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentInstructionBinding.inflate(inflater, container, false)

        binding.continueButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment()
            )
        )
        return binding.root
    }

}