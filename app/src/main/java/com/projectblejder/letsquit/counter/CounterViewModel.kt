package com.projectblejder.letsquit.counter

import android.databinding.Bindable
import com.projectblejder.letsquit.shared.MyHabit
import com.projectblejder.letsquit.shared.framework.Clock
import com.projectblejder.letsquit.shared.framework.binding.BaseBindableModel
import com.projectblejder.letsquit.shared.framework.binding.Bind
import org.joda.time.DateTime
import org.joda.time.DurationFieldType

class CounterViewModel(val clock: Clock, val habit: MyHabit) : BaseBindableModel() {

    @get:Bindable
    var counter by Bind(0)

    @get:Bindable
    var habitName by Bind("")

    @get:Bindable
    var day by Bind("Today")

    var selectedDate = clock.now()

    init {
        habit.getMyHabit?.also {
            habitName = it.name
        } ?: throw IllegalStateException("Habit is not yet selected")
    }

    fun nextDay() {
        setNewDay(selectedDate.withFieldAdded(DurationFieldType.days(), 1))
    }

    fun previousDate() {
        setNewDay(selectedDate.withFieldAdded(DurationFieldType.days(), -1))
    }

    private fun setNewDay(dateTime: DateTime) {
        selectedDate = dateTime
        day = when (clock.isToday(dateTime)) {
            true -> "Today"
            else -> dateTime.toString("yyyy-MM-dd")
        }
    }
}

