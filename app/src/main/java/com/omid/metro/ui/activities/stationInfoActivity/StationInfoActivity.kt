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
import com.omid.metro.utils.check.Check
import com.omid.metro.utils.colors.Colors

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
                Intent(applicationContext, ScheduleActivity::class.java).apply {
                    this.putExtra("myStationInfo", myStationsInfo)
                    startActivity(this)
                }
            }

            llAddress.setOnClickListener {
                Intent(applicationContext, MapsActivity::class.java).apply {
                    this.putExtra("myStationInfo", myStationsInfo)
                    startActivity(this)
                }
            }

            forward.setOnClickListener { finish() }
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