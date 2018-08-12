package com.projectblejder.letsquit.shared.framework

import org.joda.time.DateTime

interface Clock {

    fun isSameDay(d1: DateTime, d2: DateTime): Boolean

    fun isToday(date: DateTime): Boolean

    fun now(): DateTime
}
