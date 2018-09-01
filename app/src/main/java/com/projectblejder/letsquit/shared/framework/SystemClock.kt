package com.projectblejder.letsquit.shared.framework

import org.joda.time.DateTime

object SystemClock : Clock {

    override fun isSameDay(d1: DateTime, d2: DateTime) = d1.toLocalDate() == d2.toLocalDate()

    override fun isToday(date: DateTime) = isSameDay(date, now())

    override fun now() = DateTime.now()
}