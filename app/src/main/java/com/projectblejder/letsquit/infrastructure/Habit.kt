package com.projectblejder.letsquit.infrastructure

import io.objectbox.annotation.Id
import io.objectbox.relation.ToOne

data class Habit(
        @Id var id: Long = 0,
        var name: String = ""
)

data class Amount(
        @Id var id: Long = 0,
        var date: String = "",
        var amount: Long = 0
) {
    lateinit var habit: ToOne<Habit>
}
