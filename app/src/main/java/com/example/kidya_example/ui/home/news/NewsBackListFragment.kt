package com.example.kidya_example.ui.home.news

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
import com.example.kidya_example.adapters.NewsBackAdapter
import kotlinx.android.synthetic.main.fragment_news_back_list.*

class NewsBackListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_back_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val recyclerViewNovosti = view.findViewById<RecyclerView>(R.id.recyclerNovosti)

        //Back Home
        imageNewsBack.setOnClickListener {
            view.findNavController().popBackStack(R.id.nav_home, false)
        }

        val recyclerViewNewBackList = view.findViewById<RecyclerView>(R.id.recyclerNewsBackList)

        recyclerViewNewBackList.layoutManager = LinearLayoutManager(activity)

        val mAdapter = NewsBackAdapter()
        recyclerViewNewBackList.adapter = mAdapter

        mAdapter.onItemClick = {
            Toast.makeText(requireContext(), "Object mAdapter clicked", Toast.LENGTH_SHORT)
                .show()
//            view.findNavController().navigate(R.id.navNewsBackFragment)
        }

    }

}