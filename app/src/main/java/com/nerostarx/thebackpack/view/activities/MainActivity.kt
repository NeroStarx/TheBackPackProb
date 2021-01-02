package com.nerostarx.thebackpack.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nerostarx.thebackpack.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_TheBackPack)
        setContentView(R.layout.activity_main)
    }
}