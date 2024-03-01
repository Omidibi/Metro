package com.omid.metro.fragments.satToThuFragment

interface IViewSatToThu {
    interface View {
        fun setupBinding()

        fun setShowTime()
    }

    interface Presenter {
        fun startPresenter()
    }
}