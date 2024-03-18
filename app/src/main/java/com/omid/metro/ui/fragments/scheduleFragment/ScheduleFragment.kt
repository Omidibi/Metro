package com.omid.metro.ui.fragments.scheduleFragment

import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.omid.metro.databinding.FragmentScheduleBinding
import com.omid.metro.model.models.StationsItem
import com.omid.metro.utils.colors.Colors

class ScheduleFragment : Fragment(), IViewSchedule.View {

    lateinit var binding: FragmentScheduleBinding
    private val bundle = Bundle()
    private lateinit var schedule: StationsItem
    private val schPresenter = SchedulePresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        schPresenter.start()
        return binding.root
    }

    override fun setupBinding() {
        requireActivity().requestedOrientation = (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding = FragmentScheduleBinding.inflate(layoutInflater)
    }

    override fun init() {
        binding.apply {
            schedule = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                requireArguments().getParcelable("myStationsInfo",StationsItem::class.java)!!
            } else {
                requireArguments().getParcelable("myStationsInfo")!!
            }
            schPresenter.setShowTitle()

            val list = mutableListOf<StationsItem>()
            list.add(schedule)

            Colors.toolbarColor(schedule, binding, this@ScheduleFragment)

            bundle.putParcelable("schedule", schedule)
            requireActivity().supportFragmentManager.setFragmentResult("fridayF", bundle)
            requireActivity().supportFragmentManager.setFragmentResult("satToThuF", bundle)
        }
    }

    override fun setupTabBar() {
        binding.apply {
            tabsTL.addTab(tabsTL.newTab().setText("جمعه و روزهای تعطیل"))
            tabsTL.addTab(tabsTL.newTab().setText("شنبه تا پنجشنبه"))
            tabsTL.tabGravity = TabLayout.GRAVITY_FILL
            vpSchedule.adapter = TabsAdapter(tabsTL.tabCount, this@ScheduleFragment)
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
            forward.setOnClickListener {
                findNavController().popBackStack()
            }

            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
                findNavController().popBackStack()
            }
        }
    }

    override fun setShowTitle() {
        binding.showTitle.text = schedule.title
    }
}