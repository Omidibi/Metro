package com.omid.metro.fragments.satToThuFragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.omid.metro.databinding.FragmentSatToThuBinding
import com.omid.metro.model.models.StationsItem

class SatToThuFragment : Fragment(),IViewSatToThu.View {
    lateinit var binding: FragmentSatToThuBinding
    private lateinit var bundle: Bundle
    private lateinit var stationsItem: StationsItem
    private val satToThuPresenter = SatToThuPresenter(this)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        satToThuPresenter.start()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().supportFragmentManager.setFragmentResultListener("satToThuF", this) { _, result ->
            bundle = result
            stationsItem = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable("schedule", StationsItem::class.java)!!
            } else {
                bundle.getParcelable("schedule")!!
            }
            binding.showtime.text = stationsItem.stationDuration
        }
    }

    override fun setupBinding() {
        binding = FragmentSatToThuBinding.inflate(layoutInflater)
        binding.apply {

        }
    }
}