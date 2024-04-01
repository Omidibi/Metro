package com.omid.metro.ui.fragments.fridayFragment

interface IViewFridayF {

    interface View {

        fun setupBinding()

        fun setShowTime()
    }

    interface Presenter {

        fun startPresenter()
    }
}