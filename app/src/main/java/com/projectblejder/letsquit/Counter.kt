package com.projectblejder.letsquit

import android.content.Context
import android.content.SharedPreferences

class Counter(val context: Context) {

    private val prefs: SharedPreferences
        get() = context.getSharedPreferences("user-data", Context.MODE_PRIVATE)


    var number: Int
        get() = getMyHabit()
        set(value) = setMyHabit(value)

    private fun setMyHabit(value: Int) {
        prefs.edit().also {
            it.putInt("counter", value)
            it.apply()
        }

    }

    private fun getMyHabit(): Int {
        return prefs.getInt("counter", 0)
    }

}