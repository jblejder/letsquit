package com.projectblejder.letsquit.shared.models

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToOne

@Entity
data class Amount(
        @Id var id: Long = 0,
        var day: Long = 0,
        var amount: Long = 0
) {
    lateinit var habit: ToOne<Habit>
}

