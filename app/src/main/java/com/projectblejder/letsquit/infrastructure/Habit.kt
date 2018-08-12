package com.projectblejder.letsquit.infrastructure

import io.objectbox.annotation.Id

data class Habit(
        @Id var id: Long = 0,
        var name: String = ""
)

data class Amount(
        @Id var id: Long = 0,
        var date: String = "",
        var amount: Long
)