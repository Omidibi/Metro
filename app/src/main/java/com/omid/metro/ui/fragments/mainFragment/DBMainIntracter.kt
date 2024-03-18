package com.omid.metro.ui.fragments.mainFragment

import com.omid.metro.db.roomDB.DBInstance
import com.omid.metro.model.models.LinesItem

class DBMainIntracter {

    fun showAllLines(): MutableList<LinesItem> {
        return DBInstance.linesDbInstance.dao().showAllLines()
    }

    fun insertLines(linesItem: LinesItem) {
        DBInstance.linesDbInstance.dao().insertLines(linesItem)
    }
}