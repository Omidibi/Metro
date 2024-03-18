package com.omid.metro.utils.fontCode

import android.graphics.Typeface
import com.omid.metro.databinding.FragmentFridayBinding
import com.omid.metro.databinding.FragmentMainBinding
import com.omid.metro.databinding.FragmentSatToThuBinding
import com.omid.metro.databinding.FragmentScheduleBinding
import com.omid.metro.databinding.FragmentStationInfoBinding
import com.omid.metro.databinding.FragmentStationsListBinding
import com.omid.metro.ui.fragments.mainFragment.LinesVH
import com.omid.metro.ui.fragments.stationsListFragment.StationVH
import com.omid.metro.utils.configuration.AppConfiguration

class FontCode {

    companion object{

        fun lineAdapter(holder: LinesVH){
            holder.apply {
                val typeface = Typeface.createFromAsset(AppConfiguration.getContext().assets,"font/IRANSansMobile(FaNum).ttf")
                titleEnglish.typeface = typeface
                titlePersian.typeface = typeface
            }
        }

        fun stationAdapter(holder: StationVH){
            val typeface = Typeface.createFromAsset(AppConfiguration.getContext().assets,"font/IRANSansMobile(FaNum).ttf")
            holder.namePersian.typeface = typeface
            holder.nameEnglish.typeface = typeface
        }

        fun mainActivity(binding : FragmentMainBinding){
            val typeface = Typeface.createFromAsset(AppConfiguration.getContext().assets,"font/IRANSansMobile(FaNum).ttf")
            binding.showTitle.typeface = typeface
            binding.txtEn.typeface = typeface
            binding.txtFa.typeface = typeface
            binding.btnTry.typeface = typeface
        }

        fun scheduleActivity(binding : FragmentScheduleBinding){
            val typeface = Typeface.createFromAsset(AppConfiguration.getContext().assets,"font/IRANSansMobile(FaNum).ttf")
            binding.showTitle.typeface = typeface
        }

        fun stationInfoActivity(binding : FragmentStationInfoBinding){
            val typeface = Typeface.createFromAsset(AppConfiguration.getContext().assets,"font/IRANSansMobile(FaNum).ttf")
            binding.txtAddress.typeface = typeface
            binding.txtTitleEnglish.typeface = typeface
            binding.txtTitlePersian.typeface = typeface
            binding.txtTimeTrainEnglish.typeface = typeface
            binding.txtTimeTrainPersian.typeface = typeface
            binding.txtNearbyEnglish.typeface = typeface
            binding.txtNearbyPersian.typeface = typeface
            binding.txtTransportationEnglish.typeface = typeface
            binding.txtTransportation.typeface = typeface
            binding.txtFacilitiesEnglish.typeface = typeface
            binding.txtFacilitiesPersian.typeface = typeface
            binding.showTitle.typeface = typeface
            binding.tvTicket.typeface = typeface
            binding.tvEscalator.typeface = typeface
            binding.tvAtm.typeface = typeface
            binding.tvTaxi.typeface = typeface
            binding.tvBus.typeface = typeface
            binding.tvPhone.typeface = typeface
            binding.tvWater.typeface = typeface
            binding.tvLost.typeface = typeface
            binding.tvParking.typeface = typeface
            binding.tvElevator.typeface = typeface
        }

        fun stationsListActivity(binding : FragmentStationsListBinding){
            val typeface = Typeface.createFromAsset(AppConfiguration.getContext().assets,"font/IRANSansMobile(FaNum).ttf")
            binding.showTitle.typeface = typeface
            binding.txtEn.typeface = typeface
            binding.txtFa.typeface = typeface
            binding.btnTry.typeface = typeface
        }

        fun fridayFragment(binding : FragmentFridayBinding){
            val typeface = Typeface.createFromAsset(AppConfiguration.getContext().assets,"font/IRANSansMobile(FaNum).ttf")
            binding.showMinutes.typeface = typeface
            binding.showTitle.typeface = typeface
            binding.showtime.typeface = typeface
        }

        fun satToThuFragment(binding : FragmentSatToThuBinding){
            val typeface = Typeface.createFromAsset(AppConfiguration.getContext().assets,"font/IRANSansMobile(FaNum).ttf")
            binding.showTitle.typeface = typeface
            binding.showMinutes.typeface = typeface
            binding.showtime.typeface = typeface
        }
    }
}