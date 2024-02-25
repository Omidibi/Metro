package com.omid.metro.ui.activities.mainActivity

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.omid.metro.R
import com.omid.metro.config.AppSettings
import com.omid.metro.databinding.ActivityMainBinding
import com.omid.metro.db.LinesTbl
import com.omid.metro.model.models.Lines
import retrofit2.Call

class MainActivity : AppCompatActivity(), IViewMActivity<Lines> {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appSettings: AppSettings
    private val mainPresenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        saveDataCheck()
    }

    private fun setupBinding() {
        requestedOrientation = (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            appSettings = AppSettings()
            showTitle.text = getString(R.string.app_name)
            recyclerViewMain.visibility = View.GONE
            PB.visibility = View.VISIBLE
        }
    }

    private fun saveDataCheck() {
        binding.apply {
            if (appSettings.getLines() == 1) {
                offLine()
            } else {
                mainPresenter.getLines()
            }
        }
    }

    private fun offLine() {
        binding.apply {
            recyclerViewMain.visibility = View.VISIBLE
            PB.visibility = View.GONE
            clNoConnection.visibility = View.GONE
            val offline = LinesTbl()
            recyclerViewMain.adapter = LineAdapter(offline.showAllLines(), this@MainActivity)
            recyclerViewMain.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        }
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

    override fun errorStatus(call: Call<Lines>, t: Throwable, errorResponse: String) {
        binding.apply {
            recyclerViewMain.visibility = View.GONE
            PB.visibility = View.GONE
            clNoConnection.visibility = View.VISIBLE
            btnTry.setOnClickListener {
                PB.visibility = View.VISIBLE
                clNoConnection.visibility = View.GONE
                recyclerViewMain.visibility = View.GONE
                mainPresenter.getLines()
            }
        }
    }

    override fun okStatus(call: Call<Lines>, response: Lines) {
        binding.apply {
            recyclerViewMain.adapter = LineAdapter(response, this@MainActivity)
            recyclerViewMain.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            for (i in response) {
                val put = LinesTbl()
                put.insertLines(i)
            }
            appSettings.saveLines(1)
        }
    }
}