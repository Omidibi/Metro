package com.omid.metro.ui.fragments.stationsListFragment

import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.omid.metro.R
import com.omid.metro.databinding.FragmentStationsListBinding
import com.omid.metro.model.models.LinesItem
import com.omid.metro.model.models.Stations
import com.omid.metro.utils.networkAvailable.NetworkAvailable

class StationsListFragment : Fragment(), IViewStationList<Stations> {

    private lateinit var binding: FragmentStationsListBinding
    private lateinit var myLines: LinesItem
    private val stationsListPresenter = StationsListPresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getStations()
        saveDataCheck()
        clickEvent()
    }

    private fun setupBinding() {
        requireActivity().requestedOrientation = (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding = FragmentStationsListBinding.inflate(layoutInflater)
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.Nero)
    }

    private fun getStations() {
        myLines = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getParcelable("myLines",LinesItem::class.java)!!
        } else {
            requireArguments().getParcelable("myLines")!!
        }
        stationsListPresenter.setShowTitle()
    }

    private fun saveDataCheck() {
        binding.apply {
            if (stationsListPresenter.isNotEmptySearch(myLines.id)) {
                stationsListPresenter.hideProgress()
                stationsListPresenter.hideNoConnection()
                stationsListPresenter.showRv()
                recyclerViewStationsList.adapter = StationAdapter(stationsListPresenter.search(myLines.id), myLines,this@StationsListFragment)
                recyclerViewStationsList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            } else {
                if (NetworkAvailable.isNetworkAvailable(requireContext())) {
                    stationsListPresenter.getStations(myLines.id)
                } else {
                    errorStatus()
                }
            }
        }
    }

    private fun clickEvent() {
        binding.apply {
            forward.setOnClickListener {
                findNavController().popBackStack()
            }

            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
                findNavController().popBackStack()
            }
        }
    }

    override fun showProgress() {
        binding.pb.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.pb.visibility = View.GONE
    }

    override fun showNoConnection() {
        binding.clNoConnection.visibility = View.VISIBLE
    }

    override fun hideNoConnection() {
        binding.clNoConnection.visibility = View.GONE
    }

    override fun showRv() {
        binding.recyclerViewStationsList.visibility = View.VISIBLE
    }

    override fun hideRV() {
        binding.recyclerViewStationsList.visibility = View.GONE
    }

    override fun setShowTitle() {
        binding.showTitle.text = myLines.title
    }

    override fun okStatus(response: Stations) {
        isOkStatus(response)
    }

    private fun errorStatus() {
        binding.apply {
            stationsListPresenter.showNoConnection()
            stationsListPresenter.hideRV()
            stationsListPresenter.hideProgress()
            btnTry.setOnClickListener {
                stationsListPresenter.hideNoConnection()
                stationsListPresenter.hideRV()
                stationsListPresenter.showProgress()
                if (NetworkAvailable.isNetworkAvailable(requireContext())){
                    stationsListPresenter.getStations(myLines.id)
                } else {
                    errorStatus()
                }
            }
        }
    }

    private fun isOkStatus(response: Stations) {
        binding.apply {
            recyclerViewStationsList.adapter = StationAdapter(response, myLines,this@StationsListFragment)
            recyclerViewStationsList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            for (i in response) {
                stationsListPresenter.insertStations(i)
            }
        }
    }
}