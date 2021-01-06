package com.nerostarx.thebackpack.core

import com.nerostarx.thebackpack.model.Item
import com.nerostarx.thebackpack.model.Possibility

object AppCoreReactor {

    private var possibilityList: ArrayList<Possibility>
    = arrayListOf(Possibility(0,0, ArrayList()))

    fun remplirSac(ItemList: ArrayList<Item>,packSize: Int,possibility: Possibility):ArrayList<Possibility>{
        for(item: Item in ItemList){
            val tempList = ArrayList(ItemList)
            tempList.remove(item)
            remplirSac(tempList,packSize,possibility)
            if(possibility.totalSize+item.size <= packSize){
                val tempPoss = Possibility()
                tempPoss.totalValue = possibility.totalValue + item.value
                tempPoss.totalSize = possibility.totalSize + item.size
                tempPoss.ItemList.addAll(possibility.ItemList)
                tempPoss.ItemList.add(item)

                possibilityList.add(tempPoss)
                remplirSac(tempList,packSize,tempPoss)
            }
        }

        return possibilityList
    }

    fun getBestPossibility(possibilities : ArrayList<Possibility>):Possibility?{
        when {
            possibilities.isEmpty() -> {
                return null
            }
            possibilities.size == 1 -> {
                return possibilities[0]
            }
            else -> {
                if(possibilities[1].totalValue < possibilities[0].totalValue){
                    possibilities.removeAt(1)
                }else{
                    possibilities.removeAt(0)
                }
                return getBestPossibility(possibilities)
            }
        }
    }

    fun clearPossibilities() {
        possibilityList.clear()
        possibilityList.add(Possibility(0,0, ArrayList()))
    }
}