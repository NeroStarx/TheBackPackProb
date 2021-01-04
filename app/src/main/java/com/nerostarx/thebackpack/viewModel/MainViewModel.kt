package com.nerostarx.thebackpack.viewModel

import androidx.lifecycle.ViewModel
import com.nerostarx.thebackpack.model.Item

class MainViewModel: ViewModel() {

    private var name : String = ""
    private var backPackSize: Int = 0
    private var ItemsList: ArrayList<Item> = ArrayList()

    fun putName(newName: String){
        name = newName
    }

    fun putSize(newSize: Int){
        backPackSize = newSize
    }

    fun getName() = name

    fun getItems() = ItemsList
}