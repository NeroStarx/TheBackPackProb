package com.nerostarx.thebackpack.viewModel

import androidx.lifecycle.ViewModel
import com.nerostarx.thebackpack.core.AppCoreReactor
import com.nerostarx.thebackpack.model.Item
import com.nerostarx.thebackpack.model.Possibility

class MainViewModel: ViewModel() {

    private var name : String = ""
    private var backPackSize: Int = 0
    private var selectedItemsList: ArrayList<Item> = ArrayList()
    private var itemsList: ArrayList<Item> = arrayListOf(
            Item("BRUSH", 5,5),
            Item("PALETTE", 5,7),
            Item("CANVAS", 10,20),
            Item("COLORS", 10,10),
            Item("PENCIL", 5,3),
            Item("RUBBER", 5,2),
            Item("WATER", 15,10),
            Item("TORCH", 10,8),
            Item("PEN", 10,8),
            Item("SKETCHBOOK", 5,10),
            Item("SANITIZER", 10,1),
            Item("CHARGER", 20,5),
            Item("LAPTOP", 25,20),
            Item("MOUSE", 8,4),
            Item("PHONE", 25,9),
            Item("SELFI STICK", 5,8),
            Item("WATCH", 10,5)
    )

    fun putName(newName: String){
        name = newName
    }

    fun putSize(newSize: Int){
        backPackSize = newSize
    }

    fun updateSelectedItemsList(item: Item, mode: String){
        if(mode == "delete"){
            selectedItemsList.remove(item)
        } else{
            selectedItemsList.add(item)
        }
    }

    fun getName() = name

    fun getItems() = itemsList

    fun getSelectedItemsList() = selectedItemsList

    fun getPackSize() = backPackSize
}