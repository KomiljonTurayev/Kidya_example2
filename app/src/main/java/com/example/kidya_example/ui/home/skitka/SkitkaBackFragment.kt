package com.example.kidya_example.ui.home.skitka

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.kidya_example.R
import com.example.kidya_example.adapters.DialogColorAdapter
import com.example.kidya_example.adapters.DialogSizeAdapter
import com.example.kidya_example.adapters.ScreenSlidePagerAdapter2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_skitka_back.*

class SkitkaBackFragment : Fragment() {

    private lateinit var adapterViewPager2: ScreenSlidePagerAdapter2
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skitka_back, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //ItemColor
        recyclerColor.adapter = DialogColorAdapter()
//        adapter.notifyDataSetChanged()

        recyclerColor.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        recyclerSize.adapter = DialogSizeAdapter()
        recyclerSize.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        viewPager2 = view.findViewById(R.id.viewPager)
        adapterViewPager2 = ScreenSlidePagerAdapter2(this)
        tabLayout = view.findViewById(R.id.tabLayoutViewPager2)

        viewPager2.adapter = adapterViewPager2

        val list = ArrayList<Int>()
        list.add(R.drawable.image2)
        list.add(R.drawable.image2)
        list.add(R.drawable.image2)
        list.add(R.drawable.image2)
        list.add(R.drawable.image2)

        adapterViewPager2.update(list)

        TabLayoutMediator(tabLayout, viewPager2) { _, _ ->

        }.attach()


        // Create an instance of the tab layout from the view.
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        // Set the text for each tab.
//        tabLayout.addTab(tabLayout.newTab().setText("R.string.tab_label1"))
//        tabLayout.addTab(tabLayout.newTab().setText("R.string.tab_label2"))
        //        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label3));

        // Set the tabs to fill the entire layout.
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        // Use PagerAdapter to manage page views in fragments.
        // Each page is represented by its own fragment.
        val viewPager = view.findViewById<ViewPager2>(R.id.pager)
        val cAdapter = PagerAdapter(this)
        viewPager.adapter = cAdapter

        TabLayoutMediator(tabLayout, viewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = "Параметры"
                    }
                    1 -> {
                        tab.text = "Отзыбы"
                    }
                }
            }).attach()

        minuse.setOnClickListener {
            if (i > 1) {
                i--
                Log.i("tttt", "$i")
                quantity.text = "$i шт."
            }
        }
        plus.setOnClickListener {
            i++
            quantity.text = "$i шт."
            Log.i("tttt", "$i")
        }


        var k = 0
//Top heart
        skitkaHeart.setOnClickListener {
            Log.d("ttt", " image_heart.setOnClickListener   ")
            k = (k + 1) % 2

            if (k == 1) {
                skitkaHeartFull.visibility = View.VISIBLE
                Toast.makeText(context, "imgFull", Toast.LENGTH_SHORT).show()
            } else {
                skitkaHeartFull.visibility = View.INVISIBLE
                Toast.makeText(context, "imgEmpty", Toast.LENGTH_SHORT).show()
                k = 0
            }
        }

        imageBackHome.setOnClickListener {
            Toast.makeText(requireContext(), "Obeject nav_home clicked", Toast.LENGTH_SHORT)
                .show()
            view.findNavController().popBackStack(R.id.nav_home, false)

        }
    }

    companion object {
        var i = 1
    }

}
