package com.projectblejder.letsquit.shared.framework

import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SystemClockTest {

    @Test
    fun `it can determine if two dates are from same day`() {
        val date = SystemClock()

        val first = DateTime("2018-10-15T00:00:00Z").toDateTime(DateTimeZone.UTC)
        val second = DateTime("2018-10-15T23:59:59Z").toDateTime(DateTimeZone.UTC)

        assertTrue(date.isSameDay(first, second))
    }

    @Test
    fun `it recognises days event when are close`() {
        val date = SystemClock()

        val first = DateTime("2018-10-15T00:00:00Z")
        val second = DateTime("2018-10-14T23:59:59Z")

        assertFalse(date.isSameDay(first, second))
    }

    @Test
    fun `it shows when dates are not in same day`() {
        val date = SystemClock()

        val first = DateTime("2018-10-15T00:00:00Z")
        val second = DateTime("2018-10-16T0:0:00Z")

        assertFalse(date.isSameDay(first, second))
    }
}
