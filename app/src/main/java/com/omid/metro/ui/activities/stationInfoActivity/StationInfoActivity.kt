package com.omid.metro.ui.activities.stationInfoActivity

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.omid.metro.ui.activities.mapsActivity.MapsActivity
import com.omid.metro.databinding.ActivityStationInfoBinding
import com.omid.metro.model.models.StationsItem
import com.omid.metro.util.Check
import com.omid.metro.util.Colors

class StationInfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityStationInfoBinding
    private lateinit var bundle: Bundle
    private lateinit var myStationsInfo: StationsItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBindingAndInitialize()
        clickEvent()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupBindingAndInitialize() {
        requestedOrientation = (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding = ActivityStationInfoBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            bundle = intent.extras!!
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                myStationsInfo =
                    intent.getParcelableExtra("stationsItem", StationsItem::class.java)!!
                Log.e("", "")
            } else {
                myStationsInfo = intent.getParcelableExtra("stationsItem")!!
                Log.e("", "")
            }
            showTitle.text = myStationsInfo.title
            txtTitlePersian.text = myStationsInfo.title
            txtTitleEnglish.text = myStationsInfo.titleEnglish
            txtAddress.text = myStationsInfo.address

            Check.facilitiesCheck(myStationsInfo, binding)

            Colors.titleBackground(myStationsInfo, binding)

        }
    }

    private fun clickEvent() {
        binding.apply {

            /* binding.CLSchedule.setOnClickListener {
           val intent = Intent(applicationContext,ScheduleActivity::class.java)
           intent.putExtra("myStationInfo",myStationsInfo)
           startActivity(intent)
       }*/

            llAddress.setOnClickListener {
                val intent = Intent(applicationContext, MapsActivity::class.java)
                intent.putExtra("myStationInfo", myStationsInfo)
                startActivity(intent)
            }

            forward.setOnClickListener { finish() }
        }
    }
}