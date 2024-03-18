package com.omid.metro.db.roomDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.omid.metro.model.models.LinesItem
import com.omid.metro.model.models.StationsItem

@Database(entities = [LinesItem::class, StationsItem::class], version = 2)
abstract class AppDataBase : RoomDatabase() {

    abstract fun dao(): IDao
}