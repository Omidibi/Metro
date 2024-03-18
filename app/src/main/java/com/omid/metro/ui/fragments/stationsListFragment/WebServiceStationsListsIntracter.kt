package com.omid.metro.ui.fragments.stationsListFragment

import com.omid.metro.api.WebServiceCaller
import com.omid.metro.model.listener.IListener
import com.omid.metro.model.models.Stations
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WebServiceStationsListsIntracter {

    private val webServiceCaller = WebServiceCaller()

    fun getStations(id: String, iListener: IListener<Stations>) {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                webServiceCaller.getStations(id)?.let { iListener.onSuccess(it) }
            }
        }
    }
}