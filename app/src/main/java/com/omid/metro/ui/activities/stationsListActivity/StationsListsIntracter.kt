package com.omid.metro.ui.activities.stationsListActivity

import com.omid.metro.api.WebServiceCaller
import com.omid.metro.model.listener.IListener
import com.omid.metro.model.models.Stations
import retrofit2.Call

class StationsListsIntracter {

    private val webServiceCaller = WebServiceCaller()

    fun getStations(id: String, iListener: IListener<Stations>) {
        webServiceCaller.getStations(id, object : IListener<Stations> {
            override fun onSuccess(call: Call<Stations>, response: Stations) {
                iListener.onSuccess(call, response)
            }

            override fun onFailure(call: Call<Stations>, t: Throwable, errorResponse: String) {
                iListener.onFailure(call, t, errorResponse)
            }

        })
    }
}