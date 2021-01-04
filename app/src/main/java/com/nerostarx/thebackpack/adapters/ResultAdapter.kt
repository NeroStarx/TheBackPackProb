package com.nerostarx.thebackpack.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nerostarx.thebackpack.R
import com.nerostarx.thebackpack.model.Item

class ResultAdapter(private val itemsList: ArrayList<Item>)
    :RecyclerView.Adapter<ResultAdapter.ResultHolder>() {


    class ResultHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.result_item,parent,false)

        return ResultHolder(view)
    }

    override fun onBindViewHolder(holder: ResultHolder, position: Int) {

    }

    override fun getItemCount(): Int = itemsList.size
}