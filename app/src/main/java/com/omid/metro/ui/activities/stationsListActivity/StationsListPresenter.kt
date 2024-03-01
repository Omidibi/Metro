package com.omid.metro.ui.activities.stationsListActivity

import com.omid.metro.model.listener.IListener
import com.omid.metro.model.models.Stations
import com.omid.metro.model.models.StationsItem
import retrofit2.Call

class StationsListPresenter() : IListener<Stations> {

    private lateinit var iView: IViewStationList<Stations>
    private val webServiceStationsListsIntracter = WebServiceStationsListsIntracter()
    private val dBStationsListIntracter = DBStationsListIntracter()

    constructor(iView: IViewStationList<Stations>) : this() {
        this.iView = iView
    }

    fun getStations(id: String) {
        hideRV()
        hideNoConnection()
        showProgress()
        webServiceStationsListsIntracter.getStations(id, this)
    }

    override fun onSuccess(call: Call<Stations>, response: Stations) {
        showRv()
        hideNoConnection()
        hideProgress()
        iView.okStatus(call, response)
    }

    override fun onFailure(call: Call<Stations>, t: Throwable, errorResponse: String) {
        hideRV()
        showNoConnection()
        hideProgress()
        iView.errorStatus(call, t, errorResponse)
    }

    fun showProgress() {
        iView.showProgress()
    }

    fun hideProgress() {
        iView.hideProgress()
    }

    fun showNoConnection() {
        iView.showNoConnection()
    }

    fun hideNoConnection() {
        iView.hideNoConnection()
    }

    fun showRv() {
        iView.showRv()
    }

    fun hideRV() {
        iView.hideRV()
    }

    fun setShowTitle() {
        iView.setShowTitle()
    }

    fun search(lineId: String): MutableList<StationsItem> {
        return dBStationsListIntracter.search(lineId)
    }

    fun insertStations(stationsItem: StationsItem): Long {
        return dBStationsListIntracter.insertStations(stationsItem)
    }
}