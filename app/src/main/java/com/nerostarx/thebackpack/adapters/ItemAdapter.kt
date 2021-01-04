package com.nerostarx.thebackpack.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nerostarx.thebackpack.R
import com.nerostarx.thebackpack.model.Item
import com.nerostarx.thebackpack.viewModel.MainViewModel

class ItemAdapter(private val viewModel: MainViewModel)
    :RecyclerView.Adapter<ItemAdapter.ItemHolder>() {


    class ItemHolder(itemView : View):RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.item_image)
        val itemName: TextView = itemView.findViewById(R.id.item_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)

        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = viewModel.getItems()[position]

        holder.itemName.text = item.name

        holder.itemImage.setOnClickListener {
            if(viewModel.getSelectedItemsList().contains(item)){
                viewModel.updateSelectedItemsList(item,"delete")
                holder.itemImage.setImageResource(R.drawable.ic_launcher_foreground)
                holder.itemName.alpha = 1F
            }else{
                viewModel.updateSelectedItemsList(item,"add")
                holder.itemImage.setImageResource(R.drawable.ic_check)
                holder.itemName.alpha = 0.5F
            }
        }
    }

    override fun getItemCount(): Int = viewModel.getItems().size
}