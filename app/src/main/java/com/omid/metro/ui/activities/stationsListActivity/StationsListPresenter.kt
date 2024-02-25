package com.omid.metro.ui.activities.stationsListActivity

import com.omid.metro.model.listener.IListener
import com.omid.metro.model.models.Stations
import retrofit2.Call

class StationsListPresenter() : IListener<Stations> {

    private lateinit var iView: IViewStationList<Stations>
    private val stationListIntracter = StationsListsIntracter()

    constructor(iView: IViewStationList<Stations>) : this() {
        this.iView = iView
    }

    fun getStations(id: String) {
        iView.hideRV()
        iView.hideNoConnection()
        iView.showProgress()
        stationListIntracter.getStations(id, this)
    }

    override fun onSuccess(call: Call<Stations>, response: Stations) {
        iView.showRv()
        iView.hideNoConnection()
        iView.hideProgress()
        iView.okStatus(call, response)
    }

    override fun onFailure(call: Call<Stations>, t: Throwable, errorResponse: String) {
        iView.hideRV()
        iView.showNoConnection()
        iView.hideProgress()
        iView.errorStatus(call, t, errorResponse)
    }
}