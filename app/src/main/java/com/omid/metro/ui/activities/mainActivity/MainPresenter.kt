package com.omid.metro.ui.activities.mainActivity

import com.omid.metro.model.listener.IListener
import com.omid.metro.model.models.Lines
import com.omid.metro.model.models.LinesItem
import retrofit2.Call

class MainPresenter() : IListener<Lines> {
    private lateinit var iView: IViewMActivity<Lines>
    private val webServiceMainIntracter = WebServiceMainIntracter()
    private val dbMainIntracter = DBMainIntracter()

    constructor(iView: IViewMActivity<Lines>) : this() {
        this.iView = iView
    }

    fun getLines() {
        hideRv()
        showProgress()
        hideNoConnection()
        webServiceMainIntracter.getLines(this)
    }


    override fun onSuccess(call: Call<Lines>, response: Lines) {
        showRv()
        hideProgress()
        hideNoConnection()
        iView.okStatus(call, response)
    }

    override fun onFailure(call: Call<Lines>, t: Throwable, errorResponse: String) {
        hideRv()
        hideProgress()
        showNoConnection()
        iView.errorStatus(call, t, errorResponse)
    }

    fun setShowTitle() {
        iView.setShowTitle()
    }

    fun showRv() {
        iView.showRv()
    }

    fun hideRv() {
        iView.hideRv()
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

    fun showAllLines(): MutableList<LinesItem> {
        return dbMainIntracter.showAllLines()
    }

    fun insertLines(linesItem: LinesItem): Long {
        return dbMainIntracter.insertLines(linesItem)
    }
}