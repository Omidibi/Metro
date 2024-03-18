package com.omid.metro.ui.fragments.mainFragment

import com.omid.metro.model.listener.IListener
import com.omid.metro.model.models.Lines
import com.omid.metro.model.models.LinesItem

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

    override fun onSuccess(response: Lines) {
        showRv()
        hideProgress()
        hideNoConnection()
        iView.okStatus(response)
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

    fun insertLines(linesItem: LinesItem) {
        dbMainIntracter.insertLines(linesItem)
    }
}