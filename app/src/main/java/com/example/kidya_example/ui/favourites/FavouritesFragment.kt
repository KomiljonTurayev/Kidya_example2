package com.example.kidya_example.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kidya_example.R
import com.example.kidya_example.adapters.SkitkaAdapter
import kotlinx.android.synthetic.main.fragment_basket.*

class FavouritesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageBackHome.setOnClickListener {
            view.findNavController().popBackStack(R.id.nav_home, false)
        }

//         val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerSkitka)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerFavourite)

        recyclerView.layoutManager = GridLayoutManager(requireActivity(), 2)
        val mAdapter = SkitkaAdapter()


//        mAdapter.onItemClick = {
//            Toast.makeText(requireContext(), "Obeject clicked", Toast.LENGTH_SHORT).show()
//            view.findNavController().navigate(R.id.nav_skitka_back)
//        }

        mAdapter.onItemClick={
            Toast.makeText(requireContext(), "Favourite clicked", Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(R.id.nav_skitka_back)
        }

        recyclerView.adapter = mAdapter
    }

}