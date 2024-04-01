package com.omid.metro.ui.fragments.fridayFragment

class FridayFragmentPresenter(private val iView: IViewFridayF.View) : IViewFridayF.Presenter {

    override fun startPresenter() {
        iView.setupBinding()
    }

    fun setShowTime() {
        iView.setShowTime()
    }
}