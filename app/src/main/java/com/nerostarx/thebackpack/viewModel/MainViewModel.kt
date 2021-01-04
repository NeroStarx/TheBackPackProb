package com.nerostarx.thebackpack.viewModel

import androidx.lifecycle.ViewModel
import com.nerostarx.thebackpack.core.AppCoreReactor
import com.nerostarx.thebackpack.model.Item
import com.nerostarx.thebackpack.model.Possibility

class MainViewModel: ViewModel() {

    private var name : String = ""
    private var backPackSize: Int = 0
    private var itemsList: ArrayList<Item> = arrayListOf(
            Item("BRUSH", 5,5),
            Item("PALETTE", 5,7),
            Item("CANVAS", 10,20),
            Item("COLORS", 10,10),
            Item("PENCIL", 5,3),
            Item("RUBBER", 5,2),
            Item("WATER", 15,10),
            Item("TORCH", 10,8)
    )
    private var selectedItemsList: ArrayList<Item> = ArrayList()
    private var bestPossibility: Possibility? = null

    fun putName(newName: String){
        name = newName
    }

    fun putSize(newSize: Int){
        backPackSize = newSize
    }

    fun updateSelectedItemsList(item: Item, mode: String){
        if(mode == "delete")
            selectedItemsList.remove(item)
        else
            selectedItemsList.add(item)
    }

    fun getName() = name

    fun getItems() = itemsList

    fun getSelectedItemsList() = selectedItemsList

    fun processSelection(){
        val possibilities = AppCoreReactor.remplirSac(selectedItemsList,backPackSize, Possibility())
        bestPossibility = AppCoreReactor.getBestPossibility(possibilities)
    }

    fun getBestPossibility() = bestPossibility
}