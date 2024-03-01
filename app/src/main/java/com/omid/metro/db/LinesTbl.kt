package com.omid.metro.db

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.omid.metro.model.models.LinesItem
import com.omid.metro.utils.configuration.AppConfiguration

class LinesTbl : SQLiteOpenHelper(AppConfiguration.getContext(), "LinesTbl", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val linesTbl = "Create Table tbl_Lines(id Integer PRIMARY KEY AUTOINCREMENT, line_id Text,title Text,title_english Text ,description Text,color Text)"
        db?.execSQL(linesTbl)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertLines(linesItem: LinesItem): Long {
        val db: SQLiteDatabase = writableDatabase
        val content = ContentValues()
        content.put("line_id", linesItem.id)
        content.put("title",linesItem.title)
        content.put("title_english",linesItem.titleEnglish)
        content.put("description",linesItem.description)
        content.put("color",linesItem.color)
        return db.insert("tbl_Lines", null, content)
    }

    fun showAllLines(): MutableList<LinesItem>{
    val db : SQLiteDatabase = readableDatabase
        val query = "Select * from tbl_Lines"
        val myLines = mutableListOf<LinesItem>()
        val cursor : Cursor = db.rawQuery(query,null)
        try {
            while (cursor.moveToNext()) {
                val id = cursor.getInt(0)
                val lineId = cursor.getString(1)
                val title = cursor.getString(2)
                val titleEnglish = cursor.getString(3)
                val description = cursor.getString(4)
                val color = cursor.getString(5)
                myLines.add(LinesItem(color, description, lineId, title, titleEnglish))

            }
        }finally {
            cursor.close()
        }
        return myLines
    }
}