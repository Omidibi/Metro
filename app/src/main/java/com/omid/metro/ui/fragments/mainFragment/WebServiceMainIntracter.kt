package com.omid.metro.ui.fragments.mainFragment

import com.omid.metro.api.WebServiceCaller
import com.omid.metro.model.listener.IListener
import com.omid.metro.model.models.Lines

class WebServiceMainIntracter {

    private val webServiceCaller = WebServiceCaller()

    fun getLines(iListener: IListener<Lines>) {
        webServiceCaller.getLines(object : IListener<Lines> {
            override fun onSuccess(response: Lines) {
                iListener.onSuccess(response)
            }
        })
    }
}