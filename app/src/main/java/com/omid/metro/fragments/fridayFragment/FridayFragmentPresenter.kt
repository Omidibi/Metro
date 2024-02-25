package com.omid.metro.fragments.fridayFragment

class FridayFragmentPresenter(private val iView: IViewFridayF.View) : IViewFridayF.Presenter {
    override fun start() {
        iView.setupBinding()
    }
}