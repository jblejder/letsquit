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
            it.putInt("my-habit-amount", value?.amount ?: 0)
            it.apply()
        }

    }

    private fun getMyHabit(): Habit? {
        val name = prefs.getString("my-habit", null) ?: return null
        val amount = prefs.getInt("my-habit-amount", 0)
        return Habit(name, amount)
    }

}
