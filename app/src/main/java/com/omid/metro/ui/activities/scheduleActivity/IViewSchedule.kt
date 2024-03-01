package com.omid.metro.ui.activities.scheduleActivity

interface IViewSchedule {
    interface View {
        fun setupBinding()

        fun init()

        fun setupTabBar()

        fun clickEvents()

        fun setShowTitle()
    }

    interface Presenter {
        fun start()
    }
}