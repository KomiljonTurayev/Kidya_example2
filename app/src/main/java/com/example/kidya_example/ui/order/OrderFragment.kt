package com.example.kidya_example.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kidya_example.R
import com.example.kidya_example.adapters.OrderAdapter
import kotlinx.android.synthetic.main.fragment_order.*

class OrderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageBackHome.setOnClickListener {
            Toast.makeText(requireContext(), "imageBackHome", Toast.LENGTH_SHORT).show()
            view.findNavController().popBackStack(R.id.nav_home, false)
        }


        val mAdapter = OrderAdapter()
        recyclerOrder.layoutManager =
            LinearLayoutManager(requireContext())

        mAdapter.onItemClick = {
            Toast.makeText(requireContext(), "mAdapter", Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(R.id.nav_order_back)
        }

        recyclerOrder.adapter = mAdapter


//        mAdapter.setOn{
//
//        }
//        llContent.setOnClickListener {
//            Toast.makeText(requireContext(), "llContent", Toast.LENGTH_SHORT).show()
//            view.findNavController().navigate(R.id.nav_order_back)
//        }
//
//        viewCircle1.backgroundTintList =  ColorStateList.valueOf(Color.parseColor("#F53688"))
//        viewCircle2.backgroundTintList =  ColorStateList.valueOf(Color.parseColor("#F53688"))
//        view1.backgroundTintList =  ColorStateList.valueOf(Color.parseColor("#F53688"))
//        view2.backgroundTintList =  ColorStateList.valueOf(Color.parseColor("#F53688"))
//        viewCircle3.backgroundTintList =  ColorStateList.valueOf(Color.parseColor("#F53688"))
    }
}