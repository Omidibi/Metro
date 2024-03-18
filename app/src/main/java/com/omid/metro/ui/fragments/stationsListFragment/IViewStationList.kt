package com.omid.metro.ui.fragments.stationsListFragment

interface IViewStationList<T> {

    fun showProgress()

    fun hideProgress()

    fun showNoConnection()

    fun hideNoConnection()

    fun showRv()

    fun hideRV()

    fun setShowTitle()

    fun okStatus(response: T)
}