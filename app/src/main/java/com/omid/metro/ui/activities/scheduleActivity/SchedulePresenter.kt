package com.omid.metro.ui.activities.scheduleActivity

class SchedulePresenter(private val iView: IViewSchedule.View) : IViewSchedule.Presenter {
    override fun start() {
        iView.setupBinding()
        iView.init()
        iView.setupTabBar()
        iView.clickEvents()
    }
}