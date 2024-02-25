package com.omid.metro.ui.activities.stationInfoActivity

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.omid.metro.databinding.ActivityStationInfoBinding
import com.omid.metro.model.models.StationsItem
import com.omid.metro.ui.activities.mapsActivity.MapsActivity
import com.omid.metro.ui.activities.scheduleActivity.ScheduleActivity
import com.omid.metro.util.Check
import com.omid.metro.util.Colors

class StationInfoActivity : AppCompatActivity(), IViewStationInfo.View {
    lateinit var binding: ActivityStationInfoBinding
    private lateinit var myStationsInfo: StationsItem
    private val stationInfoPresenter = StationInfoPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getAndInit()
        stationInfoPresenter.start()
    }

    private fun getAndInit() {
        myStationsInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("stationsItem", StationsItem::class.java)!!
        } else {
            intent.getParcelableExtra("stationsItem")!!
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun setupBinding() {
        requestedOrientation = (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding = ActivityStationInfoBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
        }
    }

    override fun checkForView() {
        binding.apply {
            showTitle.text = myStationsInfo.title
            txtTitlePersian.text = myStationsInfo.title
            txtTitleEnglish.text = myStationsInfo.titleEnglish
            txtAddress.text = myStationsInfo.address

            Check.facilitiesCheck(myStationsInfo, binding)

            Colors.titleBackground(myStationsInfo, binding)
        }
    }

    override fun clickEvents() {
        binding.apply {

            CLSchedule.setOnClickListener {
                val intent = Intent(applicationContext, ScheduleActivity::class.java)
                intent.putExtra("myStationInfo", myStationsInfo)
                startActivity(intent)
            }

            llAddress.setOnClickListener {
                val intent = Intent(applicationContext, MapsActivity::class.java)
                intent.putExtra("myStationInfo", myStationsInfo)
                startActivity(intent)
            }

            forward.setOnClickListener { finish() }
        }
    }
}