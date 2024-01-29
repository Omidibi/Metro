package com.omid.metro.ui.activities.mainActivity

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.omid.metro.R
import com.omid.metro.api.WebServiceCaller
import com.omid.metro.config.AppSettings
import com.omid.metro.databinding.ActivityMainBinding
import com.omid.metro.db.LinesTbl
import com.omid.metro.model.listener.IListener
import com.omid.metro.model.models.Lines
import retrofit2.Call

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var appSettings: AppSettings
    private val webServiceCaller = WebServiceCaller()
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
                Log.e("", "")
            } else {
                onLine()
                Log.e("", "")
            }
        }
    }

    private fun onLine() {
        binding.apply {
            PB.visibility = View.VISIBLE
            clNoConnection.visibility = View.GONE
            webServiceCaller.getLines(object : IListener<Lines> {
                override fun onSuccess(call: Call<Lines>, response: Lines) {
                    Log.e("", "")
                    recyclerViewMain.visibility = View.VISIBLE
                    PB.visibility = View.GONE
                    clNoConnection.visibility = View.GONE
                    recyclerViewMain.adapter = LineAdapter(response, this@MainActivity)
                    recyclerViewMain.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                    for (i in response) {
                        val put = LinesTbl()
                        put.insertLines(i)
                        Log.e("", "")
                    }
                    appSettings.saveLines(1)
                }

                override fun onFailure(call: Call<Lines>, t: Throwable, errorResponse: String) {
                    Log.e("", "")
                    recyclerViewMain.visibility = View.GONE
                    PB.visibility = View.GONE
                    clNoConnection.visibility = View.VISIBLE
                    btnTry.setOnClickListener {
                        checkAgain()
                    }
                }
            })
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

    private fun checkAgain() {
        binding.apply {
            PB.visibility = View.VISIBLE
            clNoConnection.visibility = View.GONE
            webServiceCaller.getLines(object : IListener<Lines> {
                override fun onSuccess(call: Call<Lines>, response: Lines) {
                    recyclerViewMain.visibility = View.VISIBLE
                    PB.visibility = View.GONE
                    clNoConnection.visibility = View.GONE
                    recyclerViewMain.adapter = LineAdapter(response, this@MainActivity)
                    recyclerViewMain.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                    for (i in response) {
                        val put = LinesTbl()
                        put.insertLines(i)
                        Log.e("", "")
                    }
                    appSettings.saveLines(1)
                }

                override fun onFailure(call: Call<Lines>, t: Throwable, errorResponse: String) {
                    recyclerViewMain.visibility = View.GONE
                    PB.visibility = View.VISIBLE
                    clNoConnection.visibility = View.VISIBLE
                }
            })
        }
    }
}