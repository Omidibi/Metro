package com.omid.metro.ui.fragments.stationsListFragment

import com.omid.metro.db.roomDB.DBInstance
import com.omid.metro.model.models.StationsItem

class DBStationsListIntracter {

    fun search(lineId: String): MutableList<StationsItem> {
        return DBInstance.stationsDbInstance.dao().searchStations(lineId)
    }

    fun isNotEmptySearch(lineId: String): Boolean {
        return DBInstance.stationsDbInstance.dao().searchStations(lineId).isNotEmpty()
    }

    fun insertStations(stationsItem: StationsItem) {
        return DBInstance.stationsDbInstance.dao().insertStation(stationsItem)
    }
}