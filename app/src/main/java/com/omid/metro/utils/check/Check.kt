package com.omid.metro.utils.check

import android.view.View
import androidx.core.content.ContextCompat
import com.omid.metro.R
import com.omid.metro.databinding.FragmentStationInfoBinding
import com.omid.metro.model.models.StationsItem
import com.omid.metro.ui.fragments.stationsListFragment.StationVH
import com.omid.metro.utils.configuration.AppConfiguration

class Check {

    companion object {

        fun facilitiesCheck(myStationsInfo: StationsItem, binding: FragmentStationInfoBinding) {
            if (myStationsInfo.title == "کرج") {
                binding.txtAddress.text = AppConfiguration.getContext().getString(R.string.karaj_address)
            }
            if (myStationsInfo.escalator == "0") {
                binding.imgEscalator.alpha = 0.4f
                binding.tvEscalator.alpha = 0.4f
            }
            if (myStationsInfo.lost == "0") {
                binding.imgLost.alpha = 0.4f
                binding.tvLost.alpha = 0.4f
            }
            if (myStationsInfo.atm == "0") {
                binding.imgAtm.alpha = 0.4f
                binding.tvAtm.alpha = 0.4f
            }
            if (myStationsInfo.bus == "0") {
                binding.imgBus.alpha = 0.4f
                binding.tvBus.alpha = 0.4f
            }
            if (myStationsInfo.elevator == "0") {
                binding.imgElevator.alpha = 0.4f
                binding.tvElevator.alpha = 0.4f
            }
            if (myStationsInfo.parking == "0") {
                binding.imgParking.alpha = 0.4f
                binding.tvParking.alpha = 0.4f
            }
            if (myStationsInfo.taxi == "0") {
                binding.imgTaxi.alpha = 0.4f
                binding.tvTaxi.alpha = 0.4f
            }
            if (myStationsInfo.phone == "0") {
                binding.imgPhone.alpha = 0.4f
                binding.tvPhone.alpha = 0.4f
            }
            if (myStationsInfo.water == "0") {
                binding.imgWater.alpha = 0.4f
                binding.tvWater.alpha = 0.4f
            }
            if (myStationsInfo.ticket == "0") {
                binding.imgTicket.alpha = 0.4f
                binding.tvTicket.alpha = 0.4f
            }
        }

        fun crossCheck(myStations: StationsItem, holder: StationVH) {

            when (myStations.crossLineId) {

                "0" -> holder.clCross.visibility = View.GONE

                "1" -> {
                    holder.clCross.visibility = View.VISIBLE
                    holder.imgCross.setColorFilter(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line1))
                }

                "2" -> {
                    holder.clCross.visibility = View.VISIBLE
                    holder.imgCross.setColorFilter(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line2))
                }

                "3" -> {
                    holder.clCross.visibility = View.VISIBLE
                    holder.imgCross.setColorFilter(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line3))
                }

                "4" -> {
                    holder.clCross.visibility = View.VISIBLE
                    holder.imgCross.setColorFilter(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line4))
                }

                "5" -> {
                    holder.clCross.visibility = View.VISIBLE
                    holder.imgCross.setColorFilter(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line5))
                }

                "6" -> {
                    holder.clCross.visibility = View.VISIBLE
                    holder.imgCross.setColorFilter(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line6))
                }

                "7" -> {
                    holder.clCross.visibility = View.VISIBLE
                    holder.imgCross.setColorFilter(ContextCompat.getColor(AppConfiguration.getContext(), R.color.Line7))
                }
            }
        }
    }
}