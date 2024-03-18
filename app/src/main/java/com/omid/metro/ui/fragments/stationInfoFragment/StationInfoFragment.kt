package com.omid.metro.ui.fragments.stationInfoFragment

import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.omid.metro.R
import com.omid.metro.databinding.FragmentStationInfoBinding
import com.omid.metro.model.models.StationsItem
import com.omid.metro.utils.check.Check
import com.omid.metro.utils.colors.Colors

class StationInfoFragment : Fragment(), IViewStationInfo.View {

    lateinit var binding: FragmentStationInfoBinding
    private lateinit var myStationsInfo: StationsItem
    private val bundle = Bundle()
    private val stationInfoPresenter = StationInfoPresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        getAndInit()
        stationInfoPresenter.start()
        return binding.root
    }

    private fun getAndInit() {
        myStationsInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getParcelable("stationsItem",StationsItem::class.java)!!
        } else {
            requireArguments().getParcelable("stationsItem")!!
        }
        bundle.putParcelable("myStationsInfo",myStationsInfo)
    }

    override fun setupBinding() {
        requireActivity().requestedOrientation = (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding = FragmentStationInfoBinding.inflate(layoutInflater)

    }

    override fun checkForView() {
        binding.apply {
            stationInfoPresenter.setShowTitle()
            stationInfoPresenter.setTitlePersian()
            stationInfoPresenter.setTitleEnglish()
            stationInfoPresenter.setAddress()
            Check.facilitiesCheck(myStationsInfo, binding)
            Colors.titleBackground(myStationsInfo, binding)
        }
    }

    override fun clickEvents() {
        binding.apply {

            CLSchedule.setOnClickListener {
                findNavController().navigate(R.id.action_stationInfoFragment_to_scheduleFragment,bundle)
            }

            llAddress.setOnClickListener {
                findNavController().navigate(R.id.action_stationInfoFragment_to_mapsActivity,bundle)
            }

            forward.setOnClickListener {
                findNavController().popBackStack()
            }

            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
                findNavController().popBackStack()
            }
        }
    }

    override fun setShowTitle() {
        binding.showTitle.text = myStationsInfo.title
    }

    override fun setTitlePersian() {
        binding.txtTitlePersian.text = myStationsInfo.title
    }

    override fun setTitleEnglish() {
        binding.txtTitleEnglish.text = myStationsInfo.titleEnglish
    }

    override fun setAddress() {
        binding.txtAddress.text = myStationsInfo.address
    }
}