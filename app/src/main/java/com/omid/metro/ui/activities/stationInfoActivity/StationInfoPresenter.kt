package com.omid.metro.ui.activities.stationInfoActivity

class StationInfoPresenter() : IViewStationInfo.Presenter {
    private lateinit var iView: IViewStationInfo.View

    constructor(iViewStationInfo: IViewStationInfo.View) : this() {
        this.iView = iViewStationInfo
    }

    override fun start() {
        iView.setupBinding()
        iView.checkForView()
        iView.clickEvents()
    }

    fun setShowTitle() {
        iView.setShowTitle()
    }

    fun setTitlePersian() {
        iView.setTitlePersian()
    }

    fun setTitleEnglish() {
        iView.setTitleEnglish()
    }

    fun setAddress() {
        iView.setAddress()
    }
}