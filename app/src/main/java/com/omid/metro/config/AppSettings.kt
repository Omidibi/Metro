package com.omid.metro.config

import android.content.Context
import android.content.SharedPreferences
import com.omid.metro.util.configuration.AppConfiguration

class AppSettings {
    private var sharedPreferences: SharedPreferences = AppConfiguration.getContext().getSharedPreferences("setting", Context.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = sharedPreferences.edit()

    fun saveLines(state: Int) {
        editor.putInt("linesState", state)
        editor.commit()
    }

    fun getLines(): Int {
        return sharedPreferences.getInt("linesState", 0)
    }
}