package com.omid.metro.ui.activities.stationsListActivity

import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.omid.metro.databinding.ActivityStationsListBinding
import com.omid.metro.model.models.LinesItem
import com.omid.metro.model.models.Stations
import retrofit2.Call

class StationsListActivity : AppCompatActivity(), IViewStationList<Stations> {
    private lateinit var binding: ActivityStationsListBinding
    private lateinit var myLines: LinesItem
    private val stationsListPresenter = StationsListPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        getStations()
        saveDataCheck()
        clickEvent()
    }

    private fun setupBinding() {
        requestedOrientation = (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding = ActivityStationsListBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
        }
    }

    private fun getStations() {
        myLines = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("myLines", LinesItem::class.java)!!
        } else {
            intent.getParcelableExtra("myLines")!!
        }
        stationsListPresenter.setShowTitle()
    }

    private fun saveDataCheck() {
        binding.apply {
            if (stationsListPresenter.search(myLines.id).isNotEmpty()) {
                stationsListPresenter.hideProgress()
                stationsListPresenter.hideNoConnection()
                stationsListPresenter.showRv()
                recyclerViewStationsList.adapter = StationAdapter(stationsListPresenter.search(myLines.id), myLines)
                recyclerViewStationsList.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            } else {
              stationsListPresenter.getStations(myLines.id)
            }
        }
    }

    private fun clickEvent() {
        binding.apply {
            forward.setOnClickListener { finish() }
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

    override fun errorStatus(call: Call<Stations>, t: Throwable, errorResponse: String) {
      errorStatus()
    }

    override fun okStatus(call: Call<Stations>, response: Stations) {
       okStatus(response)
    }

    private fun errorStatus(){
        binding.apply {
            stationsListPresenter.showNoConnection()
            stationsListPresenter.hideRV()
            stationsListPresenter.hideProgress()
            btnTry.setOnClickListener {
                stationsListPresenter.hideNoConnection()
                stationsListPresenter.hideRV()
                stationsListPresenter.showProgress()
                stationsListPresenter.getStations(myLines.id)
            }
        }
    }

    private fun okStatus(response: Stations){
        binding.apply {
            recyclerViewStationsList.adapter = StationAdapter(response, myLines)
            recyclerViewStationsList.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            for (i in response) {
                stationsListPresenter.insertStations(i)
            }
        }
    }
}