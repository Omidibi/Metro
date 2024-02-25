package com.omid.metro.ui.activities.scheduleActivity

import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.omid.metro.databinding.ActivityScheduleBinding
import com.omid.metro.model.models.StationsItem
import com.omid.metro.util.Colors

class ScheduleActivity : AppCompatActivity(), IViewSchedule.View {
    lateinit var binding: ActivityScheduleBinding
    private lateinit var bundle: Bundle
    private lateinit var schedule: StationsItem
    private val schPresenter = SchedulePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        schPresenter.start()
    }

    override fun setupBinding() {
        requestedOrientation = (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding = ActivityScheduleBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            bundle = intent.extras!!
        }
    }

    override fun init() {
        binding.apply {
            schedule = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getParcelableExtra("myStationInfo", StationsItem::class.java)!!
            } else {
                intent.getParcelableExtra("myStationInfo")!!
            }
            showTitle.text = schedule.title

            val list = mutableListOf<StationsItem>()
            list.add(schedule)

            Colors.toolbarColor(schedule, binding, this@ScheduleActivity)

            bundle.putParcelable("schedule", schedule)
            supportFragmentManager.setFragmentResult("fridayF", bundle)
            supportFragmentManager.setFragmentResult("satToThuF", bundle)
        }
    }

    override fun setupTabBar() {
        binding.apply {
            tabsTL.addTab(tabsTL.newTab().setText("جمعه و روزهای تعطیل"))
            tabsTL.addTab(tabsTL.newTab().setText("شنبه تا پنجشنبه"))
            tabsTL.tabGravity = TabLayout.GRAVITY_FILL
            val tabAdapter = TabsAdapter(tabsTL.tabCount, this@ScheduleActivity)
            vpSchedule.adapter = tabAdapter
            tabsTL.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
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

    override fun clickEvents() {
        binding.apply {
            forward.setOnClickListener { finish() }
        }
    }
}