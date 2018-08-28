package com.projectblejder.letsquit.counter

import com.projectblejder.letsquit.shared.models.Amount
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor

class Counter(store: BoxStore) {

    val box = store.boxFor<Amount>()


    var number: Int
        get() = getMyHabit()
        set(value) = setMyHabit(value)

    private fun setMyHabit(value: Int) {


    }

    private fun getMyHabit(): Int {
        return 5
    }

}
