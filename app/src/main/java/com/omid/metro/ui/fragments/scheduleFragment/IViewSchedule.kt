package com.omid.metro.ui.fragments.scheduleFragment

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