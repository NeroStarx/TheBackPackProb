package com.nerostarx.thebackpack.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nerostarx.thebackpack.R
import com.nerostarx.thebackpack.model.Item

class ItemAdapter(private val ItemsList: ArrayList<Item>):RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    class ItemHolder(itemView : View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)

        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

    }

    override fun getItemCount(): Int = ItemsList.size
}