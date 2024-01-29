package com.omid.metro.ui.activities.scheduleActivity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.omid.metro.fragments.FridayFragment
import com.omid.metro.fragments.SatToThuFragment

internal class TabsAdapter(private val totalTabs : Int, fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
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
