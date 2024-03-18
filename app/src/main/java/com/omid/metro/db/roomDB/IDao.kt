package com.omid.metro.db.roomDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.omid.metro.model.models.LinesItem
import com.omid.metro.model.models.StationsItem

@Dao
interface IDao {

    @Insert
    fun insertLines(vararg linesItem: LinesItem)

    @Query("Select * From LinesTbl")
    fun showAllLines(): MutableList<LinesItem>

    @Insert
    fun insertStation(vararg stationsItem: StationsItem)

    @Query("Select * From StationsTbl Where lineId Like :lineId")
    fun searchStations(lineId: String): MutableList<StationsItem>
}