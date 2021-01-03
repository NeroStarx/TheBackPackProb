package com.nerostarx.thebackpack.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.nerostarx.thebackpack.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_TheBackPack)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHostFragment.navController
    }
}