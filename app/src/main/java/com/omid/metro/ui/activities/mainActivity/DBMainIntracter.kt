package com.omid.metro.ui.activities.mainActivity

import com.omid.metro.db.LinesTbl
import com.omid.metro.model.models.LinesItem

class DBMainIntracter {

    private val linesTbl = LinesTbl()

    fun showAllLines(): MutableList<LinesItem> {
        return linesTbl.showAllLines()
    }

    fun insertLines(linesItem: LinesItem): Long {
        return linesTbl.insertLines(linesItem)
    }
}