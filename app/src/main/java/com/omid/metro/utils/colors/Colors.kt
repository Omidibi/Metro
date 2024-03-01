package com.omid.metro.utils.colors

import android.graphics.Color
import android.os.Build
import androidx.core.content.ContextCompat
import com.omid.metro.R
import com.omid.metro.databinding.ActivityScheduleBinding
import com.omid.metro.databinding.ActivityStationInfoBinding
import com.omid.metro.model.models.LinesItem
import com.omid.metro.model.models.StationsItem
import com.omid.metro.ui.activities.mainActivity.LinesVH
import com.omid.metro.ui.activities.scheduleActivity.ScheduleActivity
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

        fun titleBackground(myStation: StationsItem, binding: ActivityStationInfoBinding) {
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

        fun toolbarColor(schedule: StationsItem, binding: ActivityScheduleBinding, activity: ScheduleActivity) {
            when (schedule.lineId) {
                "1" -> { binding.toolbarSchedule.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(),R.color.Line1))
                    binding.tabsTL.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(),R.color.Line1))
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        activity.window.statusBarColor = ContextCompat.getColor(AppConfiguration.getContext(),R.color.Line1)}
                }

                "2" -> { binding.toolbarSchedule.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line2))
                    binding.tabsTL.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(),R.color.Line2))
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        activity.window.statusBarColor = ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line2)}
                }

                "3" -> { binding.toolbarSchedule.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line3))
                    binding.tabsTL.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line3))
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        activity.window.statusBarColor = ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line3)}
                }

                "4" -> {
                    binding.toolbarSchedule.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line4))
                    binding.tabsTL.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line4))
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        activity.window.statusBarColor = ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line4)}
                }

                "5" -> {
                    binding.toolbarSchedule.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line5))
                    binding.tabsTL.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line5))
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        activity.window.statusBarColor = ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line5)}
                }

                "6" -> {
                    binding.toolbarSchedule.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line6))
                    binding.tabsTL.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line6))
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        activity.window.statusBarColor = ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line6)}
                }

                "7" -> {
                    binding.toolbarSchedule.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line7))
                    binding.tabsTL.setBackgroundColor(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line7))
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        activity.window.statusBarColor = ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line7)}
                }
            }
        }
    }
}