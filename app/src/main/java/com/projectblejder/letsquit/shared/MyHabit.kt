package com.projectblejder.letsquit.shared

import com.projectblejder.letsquit.shared.models.Habit
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor

class MyHabit(store: BoxStore) {

    private val box = store.boxFor<Habit>()

    val isHabitSelected: Boolean
        get() = box.count() > 0

    fun selectMyBadHabit(habit: Habit) {
        if (box.count() > 1) {
            throw IllegalStateException("currently there is only one habit at time supported")
        }
        box.put(habit)
    }

    val getMyHabit: Habit?
        get() {
            val all = box.all
            if (all.isEmpty()) {
                return null
            }
            return all[0]
        }
}
