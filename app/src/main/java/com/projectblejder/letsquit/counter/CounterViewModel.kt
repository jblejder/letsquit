package com.projectblejder.letsquit.counter

import android.databinding.Bindable
import com.projectblejder.letsquit.shared.MyHabit
import com.projectblejder.letsquit.shared.framework.Clock
import com.projectblejder.letsquit.shared.framework.binding.BaseBindableModel
import com.projectblejder.letsquit.shared.framework.binding.Bind
import com.projectblejder.letsquit.shared.models.Amount
import com.projectblejder.letsquit.shared.models.Habit
import org.joda.time.DateTime
import org.joda.time.DurationFieldType

class CounterViewModel(val clock: Clock, val habit: MyHabit, val counterr: Counter) : BaseBindableModel() {

    @get:Bindable
    var counter by Bind(0L)

    @get:Bindable
    var habitName by Bind("")

    @get:Bindable
    var day by Bind("Today")

    var selectedDate = clock.now()

    private val myHabit: Habit
    private var amount: Amount


    init {
        myHabit = habit.getMyHabit?.also {
            habitName = it.name
        } ?: throw IllegalStateException("Habit is not yet selected")


        amount = counterr.getAmountFor(myHabit, selectedDate)
        counter = amount.amount
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

        amount = counterr.getAmountFor(myHabit, selectedDate)
        counter = amount.amount
    }

    fun increment(i: Int) {
        counter += i
        amount.amount = counter
        counterr.update(amount)
    }
}

