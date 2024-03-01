package com.omid.metro.ui.activities.stationsListActivity

import retrofit2.Call

interface IViewStationList<T> {

    fun showProgress()

    fun hideProgress()

    fun showNoConnection()

    fun hideNoConnection()

    fun showRv()

    fun hideRV()

    fun setShowTitle()

    fun okStatus(call: Call<T>, response: T)

    fun errorStatus(call: Call<T>, t: Throwable, errorResponse: String)
}