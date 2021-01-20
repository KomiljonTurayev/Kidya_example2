package com.example.kidya_example.adapters
import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kidya_example.R
import com.example.kidya_example.ui.home.HomeFragment
import com.example.kidya_example.ui.home.ViewPager2MiddleFragment

class ScreenSlidePagerAdapter2(activity: Fragment) : FragmentStateAdapter(activity) {

    var lists = ArrayList<Fragment>()

    fun update(list : ArrayList<Int>)
    {
       list.forEach {
           lists.add(ViewPager2MiddleFragment.newInstance(it))

           Log.i("pagerr","adding")
       }
        notifyDataSetChanged()
    }

    override fun createFragment(position: Int): Fragment {

        return lists[position]
    }

    override fun getItemCount(): Int = lists.size
}