package com.nerostarx.thebackpack.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import com.nerostarx.thebackpack.R
import com.nerostarx.thebackpack.adapters.ResultAdapter
import com.nerostarx.thebackpack.viewModel.MainViewModel

class ResultFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val itemsRecycler: RecyclerView = view.findViewById(R.id.final_items_recycler)
        val linearLayout = LinearLayoutManager(requireContext(),VERTICAL,false)

        itemsRecycler.setHasFixedSize(false)
        itemsRecycler.layoutManager = linearLayout
        itemsRecycler.adapter = ResultAdapter(viewModel)
    }
}