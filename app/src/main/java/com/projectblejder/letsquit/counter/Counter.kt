package com.projectblejder.letsquit.counter

import com.projectblejder.letsquit.shared.models.Amount
import com.projectblejder.letsquit.shared.models.Amount_
import com.projectblejder.letsquit.shared.models.Habit
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor
import io.objectbox.kotlin.query
import org.joda.time.DateTime

class Counter(store: BoxStore) {

    private val box = store.boxFor<Amount>()


    fun update(value: Amount) {
        box.put(value)
    }

    fun getAmountFor(habit: Habit, date: DateTime): Amount {
        val dateString = date.toString("yyyy-MM-dd")
        val query = box.query {
            equal(Amount_.habitId, habit.id)
            equal(Amount_.date, dateString)
        }
        return query.findFirst() ?: Amount(0, dateString, 0).also {
            it.habit.target = habit
        }
    }
}
