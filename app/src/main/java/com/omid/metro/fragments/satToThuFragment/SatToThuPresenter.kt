package com.omid.metro.fragments.satToThuFragment

class SatToThuPresenter(private val iView: IViewSatToThu.View) : IViewSatToThu.Presenter {
    override fun start() {
        iView.setupBinding()
    }
}