package com.example.kidya_example.ui.bell

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kidya_example.R
import com.example.kidya_example.adapters.BellAdapter
import kotlinx.android.synthetic.main.fragment_bell.*
import kotlinx.android.synthetic.main.item_bell.*

class BellFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bell, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageBackHome.setOnClickListener {
            view.findNavController().popBackStack(R.id.nav_home,false)
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerBell)

        val mAdapter = BellAdapter()

        recyclerView.layoutManager = LinearLayoutManager(activity)

        recyclerView.adapter = mAdapter

//        imageBellMore?.setOnClickListener {
//            Toast.makeText(requireContext(), "textViewInfo", Toast.LENGTH_SHORT).show()
//        }

    }
}