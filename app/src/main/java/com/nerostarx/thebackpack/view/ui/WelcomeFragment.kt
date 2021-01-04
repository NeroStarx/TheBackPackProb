package com.nerostarx.thebackpack.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nerostarx.thebackpack.R
import com.nerostarx.thebackpack.viewModel.MainViewModel


class WelcomeFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val confirmButton: Button = view.findViewById(R.id.confirm_name_button)
        val nameInput: EditText = view.findViewById(R.id.name_input_layout)
        val packSizeInput: EditText = view.findViewById(R.id.packsize_input_layout)

        confirmButton.setOnClickListener{
            storeName(nameInput.text.toString(),packSizeInput.text.toString())
        }
    }

    private fun storeName(name: String,packSize:String) {
        if(name.isNotEmpty() && packSize.toInt() > 0){
            viewModel.putName(name)
            viewModel.putSize(packSize.toInt())

            val navController = findNavController()
            navController.navigate(R.id.to_selection_action)
        }else{
            Toast.makeText(requireContext(), "Please add a name", LENGTH_SHORT).show()
        }
    }
}