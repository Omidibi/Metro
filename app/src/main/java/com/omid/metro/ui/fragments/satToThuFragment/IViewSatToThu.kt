package com.omid.metro.ui.fragments.satToThuFragment

interface IViewSatToThu {
    interface View {
        fun setupBinding()

        fun setShowTime()
    }

    interface Presenter {
        fun startPresenter()
    }
}