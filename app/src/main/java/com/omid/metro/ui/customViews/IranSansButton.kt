package com.omid.metro.ui.customViews

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.omid.metro.utils.configuration.AppConfiguration

class IranSansButton: AppCompatButton {

    constructor(context: Context?) : super(context!!) {
        extracted()
    }

    constructor(context: Context?, attrs: AttributeSet) : super(context!!, attrs) {
        extracted()
    }

    constructor(context: Context?, attrs: AttributeSet, defStyleAttr: Int) : super(context!!, attrs, defStyleAttr) {
        extracted()
    }

    private fun extracted() {
        val typeface = Typeface.createFromAsset(AppConfiguration.getContext().assets, "font/IRANSansMobile(FaNum).ttf")
        setTypeface(typeface)
    }
}