package com.example.kidya_example.ui.home.categorii

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kidya_example.R
import com.example.kidya_example.adapters.SkitkaAdapter
import kotlinx.android.synthetic.main.fragment_kategory_back.*

class KategoryBackFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kategory_back, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//          val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerFavourite)
//
//        recyclerView.layoutManager = GridLayoutManager(requireActivity(), 2)
//        val mAdapter = SkitkaAdapter()
//        recyclerView.adapter = mAdapter

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerCategoryBack)

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        val mAdapter = SkitkaAdapter()
        recyclerView.adapter = mAdapter

        filtr.setOnClickListener {
            Toast.makeText(requireContext(), "filtr", Toast.LENGTH_SHORT).show()
            showListDialog()
        }
    }

    private fun showListDialog() {
        val dialog = DialogCategoryFragment()

        getFragmentManager()?.let { dialog.show(it, "example") }
    }

}