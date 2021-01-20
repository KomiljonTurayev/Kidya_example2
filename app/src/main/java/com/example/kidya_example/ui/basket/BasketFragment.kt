package com.example.kidya_example.ui.basket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kidya_example.R
import com.example.kidya_example.adapters.DialogCheckAdapter
import kotlinx.android.synthetic.main.fragment_basket.*

class BasketFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basket, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Button invisible
        btnAuth.setOnClickListener {
            llAuth.visibility = View.VISIBLE
            btnAuth.visibility = View.GONE
            textAuth.visibility = View.GONE
        }

        //RecyclerView
        recyclerOplate.layoutManager = GridLayoutManager(requireContext(), 2,GridLayoutManager.VERTICAL,false)
        val mAdapter = DialogCheckAdapter()
        recyclerOplate.adapter = mAdapter

        imageBackHome.setOnClickListener {
            view.findNavController().popBackStack(R.id.nav_home, false)
        }
        val spinner: Spinner = view.findViewById(R.id.planets_spinner)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        val spinner2: Spinner = view.findViewById(R.id.planets_spinner2)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner2.adapter = adapter
        }

    }

}