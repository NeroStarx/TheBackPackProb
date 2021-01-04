package com.nerostarx.thebackpack.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nerostarx.thebackpack.R
import com.nerostarx.thebackpack.core.AppCoreReactor
import com.nerostarx.thebackpack.model.Item
import com.nerostarx.thebackpack.model.Possibility
import com.nerostarx.thebackpack.viewModel.MainViewModel

class ResultAdapter(private val viewModel: MainViewModel)
    :RecyclerView.Adapter<ResultAdapter.ResultHolder>() {

    var possibility: Possibility? = null

    init {
        val possibilities = AppCoreReactor.remplirSac(viewModel.getSelectedItemsList()
                ,viewModel.getPackSize(), Possibility(0,0,ArrayList()))
        possibility = AppCoreReactor.getBestPossibility(possibilities)
    }


    class ResultHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val resultItemName: TextView = itemView.findViewById(R.id.result_item_name)
        val resultItemDetails: TextView = itemView.findViewById(R.id.result_item_details)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.result_item, parent, false)

        return ResultHolder(view)
    }

    override fun onBindViewHolder(holder: ResultHolder, position: Int) {
        val item = possibility!!.ItemList[position]

        holder.resultItemName.text = item.name
        holder.resultItemDetails.text = "VALUED BY: ${item.value}/${viewModel.getPackSize()}"
    }

    override fun getItemCount(): Int = possibility?.ItemList?.size ?: 0

}
