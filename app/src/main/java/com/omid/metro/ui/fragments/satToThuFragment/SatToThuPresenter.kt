package com.omid.metro.ui.fragments.satToThuFragment

class SatToThuPresenter(private val iView: IViewSatToThu.View) : IViewSatToThu.Presenter {

    override fun startPresenter() {
        iView.setupBinding()
    }

    fun setShowTime() {
        iView.setShowTime()
    }
}