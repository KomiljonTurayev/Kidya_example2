package com.example.kidya_example.ui.drawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kidya_example.R
import com.example.kidya_example.adapters.DrawerMessageAdapter
import kotlinx.android.synthetic.main.fragment_message.*

class MessageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerDrawerMessage = view.findViewById<RecyclerView>(R.id.recyclerDrawerMessage)

        recyclerDrawerMessage.layoutManager = LinearLayoutManager(requireContext())
        val mAdapter = DrawerMessageAdapter()
        recyclerDrawerMessage.adapter = mAdapter

        imageMessageBack.setOnClickListener {
            view.findNavController().popBackStack(R.id.nav_home, false)
        }

    }

}