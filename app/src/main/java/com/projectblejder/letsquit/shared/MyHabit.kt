package com.projectblejder.letsquit.shared

import android.content.Context
import android.content.SharedPreferences

class MyHabit(val context: Context) {

    private val prefs: SharedPreferences
        get() = context.getSharedPreferences("user-data", Context.MODE_PRIVATE)


    var habit: Habit?
        get() = getMyHabit()
        set(value) = setMyHabit(value)

    private fun setMyHabit(value: Habit?) {
        prefs.edit().also {
            it.putString("my-habit", value?.name)
            it.apply()
        }

    }

    private fun getMyHabit(): Habit? {
        return prefs.getString("my-habit", null)?.let { Habit(it) }
    }

}
