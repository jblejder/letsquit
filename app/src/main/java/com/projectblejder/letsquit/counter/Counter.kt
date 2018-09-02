package com.projectblejder.letsquit.counter

import com.projectblejder.letsquit.shared.models.*
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor
import io.objectbox.kotlin.query
import org.joda.time.DateTime
import org.joda.time.Days

class Counter(store: BoxStore) {

    private val box = store.boxFor<Amount>()
    private val meta = store.boxFor<HabitMetadata>()


    fun update(value: Amount) {
        box.put(value)
    }

    fun startDate(habit: Habit): DateTime {
        return meta.query {
            equal(HabitMetadata_.habitId, habit.id)
        }.findFirst()!!.let {
            DateTime.parse(it.startDate)
        }
    }

    fun daysBetween(start: DateTime, current: DateTime): Long {
        return Days.daysBetween(start.toLocalDate(), current.toLocalDate()).days.toLong()
    }

    fun getAmountFor(habit: Habit, date: DateTime): Amount {
        val between = daysBetween(startDate(habit), date)
        val query = box.query {
            equal(Amount_.habitId, habit.id)
            equal(Amount_.day, between)
        }
        return query.findFirst() ?: Amount(0, between, 0).also {
            it.habit.target = habit
        }
    }

    fun getDaysSet(habit: Habit, from: DateTime, to: DateTime): List<Amount> {
        val startDate = startDate(habit)
        val startDay = daysBetween(startDate, from)
        val endDay = daysBetween(startDate, to)

        return box.query {
            between(Amount_.day, startDay, endDay)
        }.find()
    }
}

val DateTime.stringDate: String
    get() = toString("yyyy-MM-dd")