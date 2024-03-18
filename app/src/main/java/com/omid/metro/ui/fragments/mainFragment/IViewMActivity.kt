package com.omid.metro.ui.fragments.mainFragment

interface IViewMActivity<T> {

    fun setShowTitle()

    fun showRv()

    fun hideRv()

    fun showProgress()

    fun hideProgress()

    fun showNoConnection()

    fun hideNoConnection()

    fun okStatus(response: T)
}