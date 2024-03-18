package com.omid.metro.ui.fragments.stationsListFragment

import com.omid.metro.model.listener.IListener
import com.omid.metro.model.models.Stations
import com.omid.metro.model.models.StationsItem

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

    override fun onSuccess(response: Stations) {
        showRv()
        hideNoConnection()
        hideProgress()
        iView.okStatus(response)
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

    fun isNotEmptySearch(lineId: String): Boolean {
        return dBStationsListIntracter.isNotEmptySearch(lineId)
    }

    fun insertStations(stationsItem: StationsItem) {
        return dBStationsListIntracter.insertStations(stationsItem)
    }
}