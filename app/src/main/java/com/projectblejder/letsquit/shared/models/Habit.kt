package com.projectblejder.letsquit.shared.models

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id


@Entity
data class Habit(
        @Id var id: Long = 0,
        var name: String = ""
)

