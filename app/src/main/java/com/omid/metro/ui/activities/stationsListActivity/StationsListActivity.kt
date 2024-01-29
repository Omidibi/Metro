package com.omid.metro.ui.activities.stationsListActivity

import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.omid.metro.api.WebServiceCaller
import com.omid.metro.config.AppSettings
import com.omid.metro.databinding.ActivityStationsListBinding
import com.omid.metro.db.StationsTbl
import com.omid.metro.model.listener.IListener
import com.omid.metro.model.models.LinesItem
import com.omid.metro.model.models.Stations
import retrofit2.Call

class StationsListActivity : AppCompatActivity() {
    lateinit var binding: ActivityStationsListBinding
    private lateinit var bundle: Bundle
    lateinit var myLines: LinesItem
    private lateinit var appSettings: AppSettings
    private lateinit var tblStations: StationsTbl
    private val webServiceCaller = WebServiceCaller()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBindingAndInitialize()
        saveDataCheck()
        clickEvent()

    }

    private fun setupBindingAndInitialize() {
        requestedOrientation = (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding = ActivityStationsListBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            tblStations = StationsTbl()
            appSettings = AppSettings()
            pb.visibility = View.VISIBLE
            recyclerViewStationsList.visibility = View.GONE
            bundle = intent.extras!!

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                myLines = intent.getParcelableExtra("myLines", LinesItem::class.java)!!
                Log.e("", "")
            } else {
                myLines = intent.getParcelableExtra("myLines")!!
                Log.e("", "")
            }
            showTitle.text = myLines.title

        }

    }

    private fun saveDataCheck() {
        binding.apply {
            if (tblStations.search(myLines.id).isNotEmpty()) {
                pb.visibility = View.GONE
                clNoConnection.visibility = View.GONE
                recyclerViewStationsList.visibility = View.VISIBLE
                recyclerViewStationsList.adapter = StationAdapter(tblStations.search(myLines.id), myLines)
                recyclerViewStationsList.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                Log.e("", "")
            } else {
                onLine()
                Log.e("", "")
            }
        }
    }

    private fun clickEvent() {
        binding.apply {
            forward.setOnClickListener {
                finish()
            }
        }
    }

    private fun onLine() {
        binding.apply {
            pb.visibility = View.VISIBLE
            clNoConnection.visibility = View.GONE
            recyclerViewStationsList.visibility = View.GONE
            webServiceCaller.getStations(myLines.id,object :IListener<Stations>{
                override fun onSuccess(call: Call<Stations>, response: Stations) {
                    pb.visibility = View.GONE
                    clNoConnection.visibility = View.GONE
                    recyclerViewStationsList.visibility = View.VISIBLE
                    recyclerViewStationsList.adapter = StationAdapter(response, myLines)
                    recyclerViewStationsList.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                    for (i in response) {
                        tblStations.insertStations(i)
                    }
                }

                override fun onFailure(call: Call<Stations>, t: Throwable, errorResponse: String) {
                    pb.visibility = View.GONE
                    clNoConnection.visibility = View.VISIBLE
                    recyclerViewStationsList.visibility = View.GONE
                    btnTry.setOnClickListener { checkAgain() }
                }
            })
        }
    }

    private fun checkAgain() {
        binding.apply {
            pb.visibility = View.VISIBLE
            clNoConnection.visibility = View.GONE
            webServiceCaller.getStations(myLines.id,object : IListener<Stations>{
                override fun onSuccess(call: Call<Stations>, response: Stations) {
                    pb.visibility = View.GONE
                    clNoConnection.visibility = View.GONE
                    recyclerViewStationsList.visibility = View.VISIBLE
                    recyclerViewStationsList.adapter = StationAdapter(response, myLines)
                    recyclerViewStationsList.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                    for (i in response) {
                        tblStations.insertStations(i)
                    }
                }

                override fun onFailure(call: Call<Stations>, t: Throwable, errorResponse: String) {
                    pb.visibility = View.GONE
                    clNoConnection.visibility = View.VISIBLE
                    recyclerViewStationsList.visibility = View.GONE
                }
            })
        }
    }
}