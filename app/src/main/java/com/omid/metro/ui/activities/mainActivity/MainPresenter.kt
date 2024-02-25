package com.omid.metro.ui.activities.mainActivity

import com.omid.metro.model.listener.IListener
import com.omid.metro.model.models.Lines
import retrofit2.Call

class MainPresenter() : IListener<Lines> {
    private lateinit var iView: IViewMActivity<Lines>
    private val mainIntracter = MainIntracter()

    constructor(iView: IViewMActivity<Lines>) : this() {
        this.iView = iView
    }

    fun getLines() {
        iView.hideRv()
        iView.showProgress()
        iView.hideNoConnection()
        mainIntracter.getLines(this)
    }


    override fun onSuccess(call: Call<Lines>, response: Lines) {
        iView.showRv()
        iView.hideProgress()
        iView.hideNoConnection()
        iView.okStatus(call, response)
    }

    override fun onFailure(call: Call<Lines>, t: Throwable, errorResponse: String) {
        iView.hideRv()
        iView.hideProgress()
        iView.showNoConnection()
        iView.errorStatus(call, t, errorResponse)
    }
}