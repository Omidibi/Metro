package com.omid.metro.ui.activities.stationInfoActivity

interface IViewStationInfo {
    interface View {
        fun setupBinding()

        fun checkForView()

        fun clickEvents()

        fun setShowTitle()

        fun setTitlePersian()

        fun setTitleEnglish()

        fun setAddress()

    }

    interface Presenter {
        fun start()
    }
}