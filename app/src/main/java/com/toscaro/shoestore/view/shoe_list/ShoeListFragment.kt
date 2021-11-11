package com.toscaro.shoestore.view.shoe_list

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.toscaro.shoestore.R
import com.toscaro.shoestore.databinding.FragmentShoeListBinding
import com.toscaro.shoestore.databinding.LayoutShoeItemBinding
import com.toscaro.shoestore.viewmodel.ShoeViewModel

class ShoeListFragment : Fragment() {

    private val viewModel by activityViewModels<ShoeViewModel>()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)

        binding = FragmentShoeListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.addNewShoeButton.setOnClickListener(Navigation.createNavigateOnClickListener(ShoeListFragmentDirections.actionShoeListFragmentToAddShoeFragment()))

        handleObservers()
        return binding.root
    }

    private fun handleObservers() {
        viewModel.shoeListLiveData.observe(viewLifecycleOwner, Observer { shoeList ->
            for ((index, shoe) in shoeList.withIndex()) {
                val shoeBinding = LayoutShoeItemBinding.inflate(layoutInflater)
                shoeBinding.shoe = shoe
                val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

                layoutParams.topMargin = getPxFromDp(16).toInt()
                layoutParams.marginStart = getPxFromDp(24).toInt()
                layoutParams.marginEnd = getPxFromDp(24).toInt()

                if (index == shoeList.lastIndex) {
                    layoutParams.bottomMargin = getPxFromDp(16).toInt()
                }

                binding.shoeItemsContainer.addView(shoeBinding.root, layoutParams)
            }
        })
    }

    private fun getPxFromDp(dp: Int): Float {
        return dp * resources.displayMetrics.density
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    /**
     * Notes
     * I was trying to use the below method as mentioned on Nanodegree course:
     * "return NavigationUI.onNavDestinationSelected(item, findNavController()) || super.onOptionsItemSelected(item)"
     * For some reason onNavDestinationSelected was not clearing the stack of this ShoeListFragment and was not respecting my action
     * popUp and popUpInclusive on navgraph...
     * I tried to search and look other implementations but it was not working.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        if (item.itemId == ShoeListFragmentDirections.actionShoeListToLoginFragment().actionId) {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListToLoginFragment())
            true
        } else {
            super.onOptionsItemSelected(item)
        }
}