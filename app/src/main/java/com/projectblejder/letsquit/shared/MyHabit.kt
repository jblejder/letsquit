package com.projectblejder.letsquit.shared

import com.projectblejder.letsquit.shared.framework.Clock
import com.projectblejder.letsquit.shared.models.Habit
import com.projectblejder.letsquit.shared.models.HabitMetadata
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor
import javax.inject.Inject

class MyHabit @Inject constructor(store: BoxStore, val clock: Clock) {

    private val box = store.boxFor<Habit>()
    private val metaBox = store.boxFor<HabitMetadata>()

    val isHabitSelected: Boolean
        get() = box.count() > 0

    fun createBadHabit(habit: Habit) {
        if (box.count() > 1) {
            throw IllegalStateException("currently there is only one habit at time supported")
        }
        box.put(habit)
        metaBox.put(HabitMetadata(startDate = clock.now().toString()).also {
            it.habit.target = habit
        })
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
