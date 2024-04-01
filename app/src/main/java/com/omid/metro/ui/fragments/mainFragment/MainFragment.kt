package com.omid.metro.ui.fragments.mainFragment

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.omid.metro.R
import com.omid.metro.config.AppSettings
import com.omid.metro.databinding.FragmentMainBinding
import com.omid.metro.model.models.Lines
import com.omid.metro.utils.networkAvailable.NetworkAvailable

class MainFragment : Fragment(), IViewMActivity<Lines> {

    private lateinit var binding: FragmentMainBinding
    private val appSettings = AppSettings()
    private val mainPresenter = MainPresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveDataCheck()
    }

    private fun setupBinding() {
        requireActivity().requestedOrientation = (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding = FragmentMainBinding.inflate(layoutInflater)
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.Nero)
        mainPresenter.setShowTitle()
    }

    private fun saveDataCheck() {
        binding.apply {
            if (appSettings.getLines() == 1) {
                offLine()
            } else {
                if (NetworkAvailable.isNetworkAvailable(requireContext())) {
                    mainPresenter.getLines()
                } else {
                    errorStatus()
                }
            }
        }
    }

    private fun offLine() {
        binding.apply {
            mainPresenter.showRv()
            mainPresenter.hideProgress()
            mainPresenter.hideNoConnection()
            recyclerViewMain.adapter = LineAdapter(mainPresenter.showAllLines(), this@MainFragment)
            recyclerViewMain.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun setShowTitle() {
        binding.showTitle.text = getString(R.string.app_name)
    }

    override fun showRv() {
        binding.recyclerViewMain.visibility = View.VISIBLE
    }

    override fun hideRv() {
        binding.recyclerViewMain.visibility = View.GONE
    }

    override fun showProgress() {
        binding.PB.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.PB.visibility = View.GONE
    }

    override fun showNoConnection() {
        binding.clNoConnection.visibility = View.VISIBLE
    }

    override fun hideNoConnection() {
        binding.clNoConnection.visibility = View.GONE
    }

    override fun okStatus(response: Lines) {
        isOkStatus(response)
    }

    private fun errorStatus() {
        binding.apply {
            mainPresenter.hideRv()
            mainPresenter.hideProgress()
            mainPresenter.showNoConnection()
            btnTry.setOnClickListener {
                mainPresenter.showProgress()
                mainPresenter.hideNoConnection()
                mainPresenter.hideRv()
                if (NetworkAvailable.isNetworkAvailable(requireContext())) {
                    mainPresenter.getLines()
                } else {
                    errorStatus()
                }
            }
        }
    }

    private fun isOkStatus(response: Lines) {
        binding.apply {
            recyclerViewMain.adapter = LineAdapter(response, this@MainFragment)
            recyclerViewMain.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            for (i in response) {
                mainPresenter.insertLines(i)
            }
            appSettings.saveLines(1)
        }
    }
}