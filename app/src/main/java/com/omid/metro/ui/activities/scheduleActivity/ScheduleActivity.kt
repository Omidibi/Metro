package com.omid.metro.ui.activities.scheduleActivity

import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.omid.metro.databinding.ActivityScheduleBinding
import com.omid.metro.model.models.StationsItem
import com.omid.metro.util.Colors

class ScheduleActivity : AppCompatActivity() {
    lateinit var binding: ActivityScheduleBinding
    private lateinit var bundle: Bundle
    private lateinit var schedule: StationsItem
    private lateinit var tabsTl: TabLayout
    private lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBindingAndInitialize()
        setupTabBarAndViewPager2()

    }

    private fun setupBindingAndInitialize() {
        requestedOrientation = (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding = ActivityScheduleBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            bundle = intent.extras!!
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                schedule = intent.getParcelableExtra("myStationInfo", StationsItem::class.java)!!
                Log.e("", "")
            } else {
                schedule = intent.getParcelableExtra("myStationInfo")!!
                Log.e("", "")
            }

            showTitle.text = schedule.title
            forward.setOnClickListener { finish() }
            val list = mutableListOf<StationsItem>()
            list.add(schedule)

            Colors.toolbarColor(schedule, binding, this@ScheduleActivity)

            bundle.putParcelable("schedule", schedule)
            supportFragmentManager.setFragmentResult("fridayF", bundle)
            supportFragmentManager.setFragmentResult("satToThuF", bundle)
        }
    }

    private fun setupTabBarAndViewPager2() {
        binding.apply {
            tabsTl = tabsTL
            viewPager2 = vpSchedule
            tabsTl.addTab(tabsTl.newTab().setText("جمعه و روزهای تعطیل"))
            tabsTl.addTab(tabsTl.newTab().setText("شنبه تا پنجشنبه"))
            tabsTl.tabGravity = TabLayout.GRAVITY_FILL
            val tabAdapter = TabsAdapter(tabsTl.tabCount, this@ScheduleActivity)
            vpSchedule.adapter = tabAdapter
            tabsTl.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    vpSchedule.currentItem = tab!!.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

            })

            vpSchedule.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    when (position) {
                        0 -> tabsTL.getTabAt(position)?.select()
                        1 -> tabsTL.getTabAt(position)?.select()
                    }

                }
            })
        }
    }
}