package com.projectblejder.letsquit.shared.models

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToOne

@Entity
data class HabitMetadata(
        @Id var id: Long = 0,
        var startDate: String = ""
) {
    lateinit var habit: ToOne<Habit>
}