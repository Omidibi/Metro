package com.omid.metro.fragments.fridayFragment

interface IViewFridayF {

    interface View {
        fun setupBinding()

        fun setShowTime()

    }

    interface Presenter {
        fun startPresenter()
    }
}