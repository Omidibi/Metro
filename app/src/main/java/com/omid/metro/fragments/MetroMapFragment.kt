package com.omid.metro.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.omid.metro.databinding.FragmentMetroMapBinding

class MetroMapFragment : Fragment() {
lateinit var binding : FragmentMetroMapBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupBinding()

        return binding.root
    }

    private fun setupBinding(){
        binding = FragmentMetroMapBinding.inflate(layoutInflater)
        binding.apply {

        }
    }

}