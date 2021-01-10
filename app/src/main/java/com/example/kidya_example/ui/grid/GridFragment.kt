package com.example.kidya_example.ui.grid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.kidya_example.R
import com.example.kidya_example.adapters.GridAdapter
import com.example.kidya_example.adapters.ScreenSlidePagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class GridFragment : Fragment() {

    private lateinit var adapterViewPager2: ScreenSlidePagerAdapter
    private lateinit var viewPagerTop: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView =view.findViewById<RecyclerView>(R.id.recyclerGrid)

        recyclerView.layoutManager = GridLayoutManager(context,2, GridLayoutManager.VERTICAL,false)

        viewPagerTop = view.findViewById(R.id.viewPagerTop)
        adapterViewPager2 = ScreenSlidePagerAdapter(this)
        tabLayout = view.findViewById(R.id.tabLayoutViewPager2Top)

        val mAdapter = GridAdapter()

//        mAdapter.onItemClick={
//            Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
//            view.findNavController().navigate(R.id.nav_kategory_back)
//        }

//        mAdapter.onItemClick={
//            Toast.makeText(requireContext(), "Favourite clicked", Toast.LENGTH_SHORT).show()
//            view.findNavController().navigate(R.id.nav_skitka_back)
//        }

        recyclerView.adapter = mAdapter

        viewPagerTop.adapter = adapterViewPager2
        val list = ArrayList<Int>()
        list.add(R.drawable.image_middle)
        list.add(R.drawable.image_middle)
        list.add(R.drawable.image_middle)
        list.add(R.drawable.image_middle)

        adapterViewPager2.update(list)

        TabLayoutMediator(tabLayout, viewPagerTop) { _, _ ->

        }.attach()

    }
}