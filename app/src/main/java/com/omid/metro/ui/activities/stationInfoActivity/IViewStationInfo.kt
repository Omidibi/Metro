package com.omid.metro.ui.activities.stationInfoActivity

interface IViewStationInfo {
    interface View {
        fun setupBinding()

        fun checkForView()

        fun clickEvents()
    }

    interface Presenter {
        fun start()
    }
}