package com.omid.metro.db.roomDB

import androidx.room.Room
import com.omid.metro.utils.configuration.AppConfiguration

object DBInstance {

    val linesDbInstance = Room.databaseBuilder(AppConfiguration.getContext(), AppDataBase::class.java, "LinesTbl")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

    val stationsDbInstance = Room.databaseBuilder(AppConfiguration.getContext(), AppDataBase::class.java, "StationsTbl")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
}