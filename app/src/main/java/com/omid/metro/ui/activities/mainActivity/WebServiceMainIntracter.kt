package com.omid.metro.ui.activities.mainActivity

import com.omid.metro.api.WebServiceCaller
import com.omid.metro.model.listener.IListener
import com.omid.metro.model.models.Lines
import retrofit2.Call

class WebServiceMainIntracter {

    private val webServiceCaller = WebServiceCaller()

    fun getLines(iListener: IListener<Lines>) {
        webServiceCaller.getLines(object : IListener<Lines> {
            override fun onSuccess(call: Call<Lines>, response: Lines) {
                iListener.onSuccess(call, response)
            }

            override fun onFailure(call: Call<Lines>, t: Throwable, errorResponse: String) {
                iListener.onFailure(call, t, errorResponse)
            }

        })
    }
}