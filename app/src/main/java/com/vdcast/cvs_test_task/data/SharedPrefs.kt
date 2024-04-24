package com.vdcast.cvs_test_task.data

import android.content.Context

class SharedPrefs(context: Context) {
    val prefs = context.getSharedPreferences("settings", Context.MODE_PRIVATE)

    val SORT_SETTINGS = "sort_settings"

    fun getSettings(): String = prefs.getString(SORT_SETTINGS, "Default") ?: "Default"
    fun putSettings(sortSettings: String) {
        prefs.edit().putString(SORT_SETTINGS, sortSettings).apply()
    }


}