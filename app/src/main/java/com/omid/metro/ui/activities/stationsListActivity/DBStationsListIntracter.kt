package com.omid.metro.ui.activities.stationsListActivity

import com.omid.metro.db.StationsTbl
import com.omid.metro.model.models.StationsItem

class DBStationsListIntracter {

    private val stationsTbl = StationsTbl()

    fun search(lineId: String): MutableList<StationsItem> {
        return stationsTbl.search(lineId)
    }

    fun insertStations(stationsItem: StationsItem): Long {
        return stationsTbl.insertStations(stationsItem)
    }
}