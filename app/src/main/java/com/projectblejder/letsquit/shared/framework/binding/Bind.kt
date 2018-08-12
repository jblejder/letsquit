package com.projectblejder.letsquit.shared.framework.binding

import com.projectblejder.letsquit.BR
import kotlin.reflect.KProperty

class Bind<P : BindViewModel, T>(var value: T) {
    operator fun getValue(parent: P, property: KProperty<*>): T = value

    operator fun setValue(parent: P, property: KProperty<*>, newValue: T) {
        value = newValue
        val field = BR::class.java.getField(property.name)
        val id = field.get(null) as? Int ?: 0
        parent.notifyPropertyChanged(id)
    }
}