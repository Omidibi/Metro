package com.omid.metro.fragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.omid.metro.databinding.FragmentFridayBinding
import com.omid.metro.model.models.StationsItem

class FridayFragment : Fragment() {
    lateinit var binding: FragmentFridayBinding
    private lateinit var bundle: Bundle
    private lateinit var stationsItem: StationsItem
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupBinding()

        return binding.root
    }

    private fun setupBinding() {
        binding = FragmentFridayBinding.inflate(layoutInflater)
        binding.apply {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().supportFragmentManager.setFragmentResultListener("fridayF", this) { _, result ->
            bundle = result
            stationsItem = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable("schedule", StationsItem::class.java)!!
            } else {
                bundle.getParcelable("schedule")!!
            }
            Log.e("", "")
            binding.showtime.text = stationsItem.stationDuration
        }
    }
}