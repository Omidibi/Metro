package com.omid.metro.ui.activities.mainActivity

import retrofit2.Call

interface IViewMActivity<T> {

    fun setShowTitle()

    fun showRv()

    fun hideRv()

    fun showProgress()

    fun hideProgress()

    fun showNoConnection()

    fun hideNoConnection()

    fun okStatus(call: Call<T>, response: T)

    fun errorStatus(call: Call<T>, t: Throwable, errorResponse: String)
}