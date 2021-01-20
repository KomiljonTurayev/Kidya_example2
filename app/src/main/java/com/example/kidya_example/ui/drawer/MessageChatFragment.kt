package com.example.kidya_example.ui.drawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kidya_example.R
import com.example.kidya_example.adapters.DrawerMessageAdapter
import com.example.kidya_example.adapters.MessageChattingAdapter
import com.example.kidya_example.adapters.showToast
import kotlinx.android.synthetic.main.fragment_message_chat.*

class MessageChatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerDrawerMessage = view.findViewById<RecyclerView>(R.id.listMessageChat)
//        list.layoutManager = GridLayoutManager(this,2)
        recyclerDrawerMessage.layoutManager = LinearLayoutManager(requireContext())
        val mAdapter = MessageChattingAdapter()
        recyclerDrawerMessage.adapter = mAdapter

        mAdapter.setOnItemClickListener {
            Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
        }
//        mAdapter.setOnItemClickListener {
//            view.findNavController().navigate(R.id.nav_message)
//        }
        imageMessageBack?.setOnClickListener {
            view.findNavController().navigate(R.id.nav_message)
        }




//        val  mAdapter = MessageChattingAdapter()
//        listMessageChat.adapter = mAdapter
//        mAdapter.setOnItemClickListener {
//            "Salom $it".showToast(requireContext())
//        }
    }

}