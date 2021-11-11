package com.toscaro.shoestore.view.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener


@BindingAdapter("isVisible")
fun isVisible(view: View, isVisible: Boolean) {
    view.visibility = if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("doubleText")
fun setDoubleInEditText(editText: TextView, doubleValue: Double?) {
    editText.text = if (doubleValue == null || doubleValue == 0.0) "" else doubleValue.toString()
}

@InverseBindingAdapter(attribute = "doubleText")
fun getDoubleInEditText(editText: EditText): Double? = editText.text.toString().toDoubleOrNull()

@BindingAdapter("doubleTextAttrChanged")
fun setTextChangeListener(editText: TextView, listener: InverseBindingListener) {
    editText.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) = listener.onChange()

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    })
}

@BindingAdapter("srcBitmap", "srcBitmapScaleType", "srcDefaultDrawable", "srcDefaultScaleType")
fun srcBitmap(
    imageView: ImageView,
    bitmap: Bitmap?,
    scaleType: ImageView.ScaleType,
    defaultDrawable: Drawable,
    defaultScaleType: ImageView.ScaleType
) {
    if (bitmap == null) {
        imageView.scaleType = defaultScaleType
        imageView.setImageDrawable(defaultDrawable)
    } else {
        imageView.scaleType = scaleType
        imageView.setImageBitmap(bitmap)
    }
}

@BindingAdapter("srcBitmap", "srcBitmapScaleType")
fun srcBitmap(
    imageView: ImageView,
    bitmap: Bitmap?,
    scaleType: ImageView.ScaleType
) {
    if (bitmap != null) {
        imageView.scaleType = scaleType
        imageView.setImageBitmap(bitmap)
    }
}