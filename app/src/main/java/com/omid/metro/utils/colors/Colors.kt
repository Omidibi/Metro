package com.omid.metro.utils.colors

import android.graphics.Color
import androidx.core.content.ContextCompat
import com.omid.metro.R
import com.omid.metro.databinding.FragmentScheduleBinding
import com.omid.metro.databinding.FragmentStationInfoBinding
import com.omid.metro.model.models.LinesItem
import com.omid.metro.model.models.StationsItem
import com.omid.metro.ui.fragments.mainFragment.LinesVH
import com.omid.metro.ui.fragments.scheduleFragment.ScheduleFragment
import com.omid.metro.utils.configuration.AppConfiguration

class Colors {

    companion object {

        fun lineCardColorSetter(holder: LinesVH, myLines: LinesItem) {
            holder.apply {
                when (myLines.id) {
                    "1" -> selectLine.setBackgroundColor(Color.parseColor(myLines.color))
                    "2" -> selectLine.setBackgroundColor(Color.parseColor(myLines.color))
                    "3" -> selectLine.setBackgroundColor(Color.parseColor(myLines.color))
                    "4" -> selectLine.setBackgroundColor(Color.parseColor(myLines.color))
                    "5" -> selectLine.setBackgroundColor(Color.parseColor(myLines.color))
                    "6" -> selectLine.setBackgroundColor(Color.parseColor(myLines.color))
                    "7" -> selectLine.setBackgroundColor(Color.parseColor(myLines.color))
                }
            }
        }

        fun titleBackground(myStation: StationsItem, binding: FragmentStationInfoBinding) {

            when (myStation.lineId) {

                "1" -> binding.llTitle.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line1))

                "2" -> binding.llTitle.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line2))

                "3" -> binding.llTitle.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line3))

                "4" -> binding.llTitle.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line4))

                "5" -> binding.llTitle.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line5))

                "6" -> binding.llTitle.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line6))

                "7" -> binding.llTitle.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line7))
            }

            when (myStation.lineId) {

                "1" -> binding.ll.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line1))

                "2" -> binding.ll.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line2))

                "3" -> binding.ll.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line3))

                "4" -> binding.ll.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(),R.color.Line4))

                "5" -> binding.ll.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line5))

                "6" -> binding.ll.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line6))

                "7" -> binding.ll.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line7))
            }
        }

        fun toolbarColor(schedule: StationsItem, binding: FragmentScheduleBinding, fragment: ScheduleFragment) {

            when (schedule.lineId) {

                "1" -> { binding.toolbarSchedule.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(),R.color.Line1))
                    binding.tabsTL.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(),R.color.Line1))
                    fragment.requireActivity().window.statusBarColor = ContextCompat.getColor(AppConfiguration.getContext(),R.color.Line1)
                }

                "2" -> { binding.toolbarSchedule.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line2))
                    binding.tabsTL.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(),R.color.Line2))
                    fragment.requireActivity().window.statusBarColor = ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line2)
                }

                "3" -> { binding.toolbarSchedule.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line3))
                    binding.tabsTL.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line3))
                    fragment.requireActivity().window.statusBarColor = ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line3)
                }

                "4" -> {
                    binding.toolbarSchedule.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line4))
                    binding.tabsTL.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line4))
                    fragment.requireActivity().window.statusBarColor = ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line4)
                }

                "5" -> {
                    binding.toolbarSchedule.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line5))
                    binding.tabsTL.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line5))
                    fragment.requireActivity().window.statusBarColor = ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line5)
                }

                "6" -> {
                    binding.toolbarSchedule.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line6))
                    binding.tabsTL.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line6))
                    fragment.requireActivity().window.statusBarColor = ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line6)
                }

                "7" -> {
                    binding.toolbarSchedule.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line7))
                    binding.tabsTL.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line7))
                    fragment.requireActivity().window.statusBarColor = ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line7)
                }
            }
        }
    }
}