package com.toscaro.shoestore.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.toscaro.shoestore.R
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
    }
}
