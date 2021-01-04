package com.nerostarx.thebackpack.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.nerostarx.thebackpack.R
import com.nerostarx.thebackpack.viewModel.MainViewModel


class SelectionFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val confirmButton: Button = view.findViewById(R.id.confirm_items_button)
        val title: TextView = view.findViewById(R.id.selection_title)
        val itemsRecycler: RecyclerView = view.findViewById(R.id.items_recycler)

        title.text = "HELLO ${viewModel.getName()}, PLEASE CHOOSE YOUR DESIRED ITEMS."

        confirmButton.setOnClickListener{
            processSelection()
        }
    }

    private fun processSelection() {
        val navController = findNavController()
        navController.navigate(R.id.to_result_action)
    }
}