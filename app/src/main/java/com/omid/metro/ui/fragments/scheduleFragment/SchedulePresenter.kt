package com.omid.metro.ui.fragments.scheduleFragment

class SchedulePresenter(private val iView: IViewSchedule.View) : IViewSchedule.Presenter {
    override fun start() {
        iView.setupBinding()
        iView.init()
        iView.setupTabBar()
        iView.clickEvents()
    }

    fun setShowTitle() {
        iView.setShowTitle()
    }
}