package com.nerostarx.thebackpack.core

import com.nerostarx.thebackpack.model.Item
import com.nerostarx.thebackpack.model.Possibility

object AppCoreReactor {

    private var possibilityList: ArrayList<Possibility> = ArrayList()

    fun remplirSac(ItemList: ArrayList<Item>,PackSize: Int,possibility: Possibility)
    :ArrayList<Possibility>{
        if(ItemList.isNotEmpty()){
            if(possibility.totalSize <= PackSize ){
                val item = ItemList[0]
                ItemList.removeAt(0)
                remplirSac(ItemList, PackSize, possibility)

                possibility.ItemList.add(item)
                possibility.totalSize += item.size
                possibility.totalValue += item.value

                remplirSac(ItemList, PackSize, possibility)
            }else{
                possibilityList.add(possibility)
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
}