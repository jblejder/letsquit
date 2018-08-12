package com.projectblejder.letsquit.counter

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.Observable
import com.projectblejder.letsquit.BR
import kotlin.reflect.KProperty

class CounterViewModel : VMObservable by VMObservableImp() {

    @get:Bindable
    var counter by Bind(0)

    @get:Bindable
    var habitName by Bind("")

    @get:Bindable
    var date by Bind("Today")

}

interface VMObservable : Observable {
    fun notifyPropertyChanged(fieldId: Int)
}

class VMObservableImp : BaseObservable(), VMObservable

class Bind<P : VMObservable, T>(var value: T) {
    operator fun getValue(parent: P, property: KProperty<*>): T = value

    operator fun setValue(parent: P, property: KProperty<*>, i: T) {
        val field = BR::class.java.getField(property.name)
        val id = field.get(null) as? Int ?: 0
        parent.notifyPropertyChanged(id)
    }
}

