package com.example.kidya_example.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.kidya_example.R
import com.example.kidya_example.adapters.KategoryAdapter
import com.example.kidya_example.adapters.NewsAdapter
import com.example.kidya_example.adapters.ScreenSlidePagerAdapter
import com.example.kidya_example.adapters.SkitkaAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
    import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var adapterViewPager2: ScreenSlidePagerAdapter
    private lateinit var adapterViewPager2Middle: ScreenSlidePagerAdapter
    private lateinit var viewPagerTop: ViewPager2
    private lateinit var tabLayout: TabLayout

    private lateinit var viewPagerMiddle: ViewPager2
    private lateinit var tabLayoutMiddle: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ll_top.setOnClickListener{
            view.findNavController().navigate(R.id.nav_news_back)
        }
        ll_middle.setOnClickListener{
            view.findNavController().navigate(R.id.nav_kategory_back)
        }
        ll_bottom.setOnClickListener{
            view.findNavController().navigate(R.id.nav_news_back)
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerSkitka)
        val recyclerViewKaregory = view.findViewById<RecyclerView>(R.id.recyclerKategory)
        val recyclerViewNovosti = view.findViewById<RecyclerView>(R.id.recyclerNovosti)

        recyclerView.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewKaregory.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewNovosti.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        viewPagerTop = view.findViewById(R.id.viewPagerTop)
        adapterViewPager2 = ScreenSlidePagerAdapter(this)
        tabLayout = view.findViewById(R.id.tabLayoutViewPager2Top)

        viewPagerMiddle = view.findViewById(R.id.viewPagerMeddle)
        adapterViewPager2Middle = ScreenSlidePagerAdapter(this)
        tabLayoutMiddle = view.findViewById(R.id.tabLayoutViewPager2Middle)

        val mAdapter = SkitkaAdapter(true)
        val mAdapterKategory = KategoryAdapter()
        val mAdapterNovosti = NewsAdapter()

        recyclerView.adapter = mAdapter
        recyclerViewKaregory.adapter = mAdapterKategory
        recyclerViewNovosti.adapter = mAdapterNovosti

        mAdapter.onItemClick = {
            Toast.makeText(requireContext(), "Obeject clicked", Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(R.id.nav_skitka_back)
        }

        mAdapterKategory.onItemClick = {
            Toast.makeText(requireContext(), "Obeject mAdapterKategory clicked", Toast.LENGTH_SHORT)
                .show()
            view.findNavController().navigate(R.id.nav_kategory_back)
        }

        mAdapterNovosti.onItemClick = {
            Toast.makeText(requireContext(), "Obeject mAdapterKategory clicked", Toast.LENGTH_SHORT)
                .show()
            view.findNavController().navigate(R.id.nav_news_back)
        }

        viewPagerTop.adapter = adapterViewPager2
        viewPagerMiddle.adapter = adapterViewPager2Middle

        val list = ArrayList<Int>()
        list.add(R.drawable.main_top_bg)
        list.add(R.drawable.main_top_bg)
        list.add(R.drawable.main_top_bg)
        list.add(R.drawable.main_top_bg)
        list.add(R.drawable.main_top_bg)

        val list2 = ArrayList<Int>()
        list2.add(R.drawable.image_middle)
        list2.add(R.drawable.image_middle)
        list2.add(R.drawable.image_middle)
        list2.add(R.drawable.image_middle)
        list2.add(R.drawable.image_middle)

        adapterViewPager2.update(list)
        adapterViewPager2Middle.update(list)

//        val tabLayout = view.findViewById(R.id.tabLayoutViewPager2Top)

//        tabLayout.setupWithViewPager(viewPagerTop)

        TabLayoutMediator(tabLayout, viewPagerTop) { _, _ ->
//            top.text ="OBJECT ${(position + 1)}"
        }.attach()

        TabLayoutMediator(tabLayoutMiddle, viewPagerMiddle) { _, _ ->
//            top.text ="OBJECT ${(position + 1)}"
        }.attach()



    }



}