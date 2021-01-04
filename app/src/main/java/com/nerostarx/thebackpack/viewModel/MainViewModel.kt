package com.nerostarx.thebackpack.viewModel

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private var name : String = ""

    fun putName(newName: String){
        name = newName
    }

    fun getName() = name
}