package com.toscaro.shoestore.view.add_shoe

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.toscaro.shoestore.databinding.FragmentAddShoeBinding
import com.toscaro.shoestore.viewmodel.ShoeViewModel
import timber.log.Timber
import java.io.FileNotFoundException


class AddShoeFragment : Fragment() {

    companion object {
        private const val PICK_FROM_GALLERY = 1000
    }

    private val viewModel by activityViewModels<ShoeViewModel>()
    lateinit var binding: FragmentAddShoeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddShoeBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.shoeViewModel = viewModel

        handleBinding()
        handleObservers()
        return binding.root
    }

    private fun handleBinding() {
        binding.shoeImage.setOnClickListener {
            startActivityForResult(Intent(Intent.ACTION_PICK).setType("image/*"), PICK_FROM_GALLERY)
        }
        binding.shoeCancelButton.setOnClickListener {
            viewModel.resetNewShoeData()
        }
        binding.saveShoeButton.setOnClickListener {
            viewModel.submitShoeCreation()
        }
    }

    private fun handleObservers() {
        viewModel.newShoeDataResetLiveEvent.observe(this) {
            findNavController().popBackStack()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_FROM_GALLERY) {
            try {
                val imageUri: Uri = data?.data!!
                val imageStream = requireActivity().contentResolver.openInputStream(imageUri)
                val selectedImage = BitmapFactory.decodeStream(imageStream)
                viewModel.updateNewShoeImage(selectedImage)
            } catch (e: FileNotFoundException) {
                Timber.d("Error while getting ${e.message}")
            }
        }
    }
}