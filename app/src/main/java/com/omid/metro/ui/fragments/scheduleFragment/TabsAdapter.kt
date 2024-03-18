package com.omid.metro.ui.fragments.scheduleFragment

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.omid.metro.ui.fragments.fridayFragment.FridayFragment
import com.omid.metro.ui.fragments.satToThuFragment.SatToThuFragment

internal class TabsAdapter(private val totalTabs : Int, fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return totalTabs
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FridayFragment()
            1 -> SatToThuFragment()
            else -> createFragment(position)
        }
    }
}
