package com.toscaro.shoestore.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.toscaro.shoestore.model.Shoe
import com.toscaro.shoestore.viewmodel.util.SingleLiveEvent

class ShoeViewModel : ViewModel() {

    private val newShoeMutableLiveData: MutableLiveData<Shoe> = MutableLiveData(Shoe())
    val newShoeLiveData: LiveData<Shoe> get() = newShoeMutableLiveData

    private val shoeListMutableLiveData: MutableLiveData<MutableList<Shoe>> = MutableLiveData(mutableListOf())
    val shoeListLiveData: LiveData<MutableList<Shoe>> get() = shoeListMutableLiveData

    private val newShoeDataResetEvent: SingleLiveEvent<Unit> = SingleLiveEvent()
    val newShoeDataResetLiveEvent: LiveData<Unit?> get() = newShoeDataResetEvent

    fun resetNewShoeData() {
        newShoeMutableLiveData.value = Shoe()
        newShoeDataResetEvent.call()
    }

    fun submitShoeCreation() {
        val newShoe = newShoeMutableLiveData.value
        if (!isNewShoeDataEmpty(newShoe)) {
            shoeListMutableLiveData.value?.add(newShoe!!)
        }
        resetNewShoeData()
    }

    private fun isNewShoeDataEmpty(shoe: Shoe?): Boolean =
        shoe?.image == null && shoe?.name.isNullOrEmpty() && shoe?.size == null && shoe?.company.isNullOrEmpty() && shoe?.description.isNullOrEmpty()


    fun updateNewShoeImage(selectedImage: Bitmap?) {
        newShoeMutableLiveData.value?.image = selectedImage
        newShoeMutableLiveData.value = newShoeMutableLiveData.value
    }
}