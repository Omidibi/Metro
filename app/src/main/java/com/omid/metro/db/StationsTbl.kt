package com.omid.metro.db

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.omid.metro.model.models.StationsItem
import com.omid.metro.util.configuration.AppConfiguration

class StationsTbl : SQLiteOpenHelper(AppConfiguration.getContext(), "StationsTbl", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
       val query = "create table tbl_Stations(id Integer PRIMARY KEY AUTOINCREMENT, station_id Text, line_id Text, order_id Text, station_duration Text, title Text, title_english Text, cross_line_id Text, address Text, ticket Text, escalator Text, atm Text, taxi Text, bus Text, phone Text,water Text, lost Text, parking Text, elevator Text, latitude Text, longitude Text)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertStations(stationsItem: StationsItem): Long{
        val db : SQLiteDatabase = writableDatabase
        val content = ContentValues()
        content.put("station_id",stationsItem.id)
        content.put("line_id",stationsItem.lineId)
        content.put("order_id",stationsItem.orderId)
        content.put("station_duration",stationsItem.stationDuration)
        content.put("title",stationsItem.title)
        content.put("title_english",stationsItem.titleEnglish)
        content.put("cross_line_id",stationsItem.crossLineId)
        content.put("address",stationsItem.address)
        content.put("ticket",stationsItem.ticket)
        content.put("escalator",stationsItem.escalator)
        content.put("atm",stationsItem.atm)
        content.put("taxi",stationsItem.taxi)
        content.put("bus",stationsItem.bus)
        content.put("phone",stationsItem.phone)
        content.put("water",stationsItem.water)
        content.put("lost",stationsItem.lost)
        content.put("parking",stationsItem.parking)
        content.put("elevator",stationsItem.elevator)
        content.put("latitude",stationsItem.latitude)
        content.put("longitude",stationsItem.longitude)
        return db.insert("tbl_Stations",null,content)
    }

    fun showAllStations(): MutableList<StationsItem>{
        val db : SQLiteDatabase = readableDatabase
        val query = "select * from tbl_Stations"
        val myStations = mutableListOf<StationsItem>()
        val cursor : Cursor = db.rawQuery(query,null)
        try {
            while (cursor.moveToNext()){
                val id = cursor.getInt(0)
                val stationId = cursor.getString(1)
                val lineId = cursor.getString(2)
                val orderId = cursor.getString(3)
                val stationDuration = cursor.getString(4)
                val title = cursor.getString(5)
                val titleEnglish = cursor.getString(6)
                val crossLineId = cursor.getString(7)
                val address = cursor.getString(8)
                val ticket = cursor.getString(9)
                val escalator = cursor.getString(10)
                val atm = cursor.getString(11)
                val taxi = cursor.getString(12)
                val bus = cursor.getString(13)
                val phone = cursor.getString(14)
                val water = cursor.getString(15)
                val lost = cursor.getString(16)
                val parking = cursor.getString(17)
                val elevator = cursor.getString(18)
                val latitude = cursor.getString(19)
                val longitude = cursor.getString(20)
                myStations.add(StationsItem(address,atm,bus,crossLineId,elevator,escalator,stationId,latitude,lineId,longitude,lost,orderId,parking,phone,stationDuration,taxi,ticket,title,titleEnglish,water))
            }
        }finally {
            cursor.close()
        }
        return myStations
    }

    fun search(lineId : String): MutableList<StationsItem>{
        val db : SQLiteDatabase = readableDatabase
        val query = "select * from tbl_Stations where line_id like '%$lineId%'"
        val myResult = mutableListOf<StationsItem>()
        val cursor : Cursor = db.rawQuery(query,null)
        try {
            while (cursor.moveToNext()){
                val id = cursor.getInt(0)
                val stationId = cursor.getString(1)
                val linesId = cursor.getString(2)
                val orderId = cursor.getString(3)
                val stationDuration = cursor.getString(4)
                val title = cursor.getString(5)
                val titleEnglish = cursor.getString(6)
                val crossLineId = cursor.getString(7)
                val address = cursor.getString(8)
                val ticket = cursor.getString(9)
                val escalator = cursor.getString(10)
                val atm = cursor.getString(11)
                val taxi = cursor.getString(12)
                val bus = cursor.getString(13)
                val phone = cursor.getString(14)
                val water = cursor.getString(15)
                val lost = cursor.getString(16)
                val parking = cursor.getString(17)
                val elevator = cursor.getString(18)
                val latitude = cursor.getString(19)
                val longitude = cursor.getString(20)
                myResult.add(StationsItem(address,atm,bus,crossLineId,elevator,escalator,stationId,latitude,linesId,longitude,lost,orderId,parking,phone,stationDuration,taxi,ticket,title,titleEnglish,water))
            }
        }finally {
            cursor.close()
        }
        return myResult
    }
}